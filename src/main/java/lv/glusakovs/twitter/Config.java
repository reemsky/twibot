package lv.glusakovs.twitter;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("twitter")
public class Config {
	private List<String> messages;
	private TwitterAccount account;
	private String cron;

	public TwitterAccount getAccount() {
		return this.account;
	}
	
	public void setAccount(TwitterAccount acc) {
		this.account = acc;
	}

	public List<String> getMessages() {
		return this.messages;
	}

	public void setMessages(List<String> msg) {
		this.messages = msg;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

}
