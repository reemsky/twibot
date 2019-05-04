package lv.glusakovs.twitter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;
import org.springframework.social.DuplicateStatusException;
import org.springframework.stereotype.Component;

@Component
public class MessagePoster extends LogEnabledClass {
	@Autowired
	private Config cfg;
	private static int index = 0; // variable for message rotation

	public void post() {
		List<String> messages;
		String message;

		TwitterAccount acc = cfg.getAccount();

		if (!acc.isValid()) {
			log.info(acc + "; valid:" + String.valueOf(acc.isValid()));
			log.info("Account is invalid - skipping message");
			return;
		}

		messages = cfg.getMessages();
		message = messages.get(index);
		
		// Today is DD of Month Year.  + message from list
		
		log.info(message);

		/*
		Twitter twitter = new TwitterTemplate(acc.getConsumerKey(), acc.getConsumerSecret(), acc.getAccessToken(),
				acc.getAccessTokenSecret());
		try {
			twitter.timelineOperations().updateStatus(message);
		} catch (DuplicateStatusException dte) {
			log.info("Twitter rejects duplicate message");
		}
		*/

		nextMessage(messages.size() - 1);
	}

	private void nextMessage(int maxSize) {
		index++;
		if (index > maxSize) {
			index = 0;
		}
	}
}
