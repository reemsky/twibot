package lv.glusakovs.twitter;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.DuplicateStatusException;
import org.springframework.social.MissingAuthorizationException;
import org.springframework.social.twitter.api.MessageTooLongException;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessagePoster extends LogEnabledClass {
	@Autowired
	private Config cfg;
	private static int index = 0; // variable for message rotation
	final String hashMethod = "MD5";
	
	public void post() {

		TwitterAccount acc = cfg.getAccount();
		log.info(acc.toString());
		
		if (!acc.isValid()) {
			log.error(acc + "; valid:" + String.valueOf(acc.isValid()));
			log.info("Account is invalid. Message will not be posted.");
			return;
		}

		String msg = getMessageToPost();
		
		log.info(msg);
		log.debug("Message length is: " + msg.length() + ", " + hashMethod + getStringHash(msg, hashMethod));
		
		Twitter twitter = new TwitterTemplate(acc.getConsumerKey(), acc.getConsumerSecret(), acc.getAccessToken(), acc.getAccessTokenSecret());
		try {
			twitter.timelineOperations().updateStatus(msg);
		} catch (DuplicateStatusException|MessageTooLongException|MissingAuthorizationException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
		nextMessage();
	}

	private String getMessageToPost(){
		String message 	= cfg.getMessages().get(index);
		LocalDate date 	= LocalDate.now();
		
		String 	weekday 	= date.getDayOfWeek().toString();
		String 	month 		= date.getMonth().toString();
		int 	day 		= date.getDayOfMonth();
		
		// Message format: Today is DayOfWeek, DD of Month Year.  + message from list
		String result = "Today is " + weekday + ", " + month + " " + day + ". " + message;
		return result;
	} 
	
	private String getStringHash(String s, String method){
		String sha256 = "Not defined";
		try {
			MessageDigest md = MessageDigest.getInstance(method);
			byte[] digest = md.digest(s.getBytes(StandardCharsets.UTF_8));
			sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			log.error("Error getting " + method + " MessageDigest instance");
			e.printStackTrace();
		}
		return sha256;
	}

	private void nextMessage() {
		index++;
		if (index > cfg.getMessages().size() - 1) {
			index = 0;
		}
	}
}
