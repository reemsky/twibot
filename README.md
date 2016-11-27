
Simple twitter bot that posts message from application.yml every provided period.

### Setup ###

* set application parameters in application.yml
* mvn package
* java -jar target/simple-twitter-bot-1.0.jar 
* java -jar target/simple-twitter-bot-1.0.jar 
--twitter.cron="0/5 0/1 * 1/1 * *" 
--twitter.account.consumerKey="aaa" 
--twitter.account.consumerSecret="bbb" 
--twitter.account.accessToken="ccc" 
--twitter.account.accessTokenSecret="ddd"


* docker build -t twibot .
* docker run -d --name my-bot twibot
