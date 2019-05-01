package lv.glusakovs.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class App extends LogEnabledClass{
	@Autowired
	MessagePoster poster;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Scheduled(cron="${twitter.cron}")
	public void runTask() {
		log.info("Scheduled task started");
		poster.post();
	}
}
