
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

Docker:
* docker build -t twibot . && docker run -dti --name mybot -e TWITTER_CRON="*/10 * * * * *" -e TWITTER_ACCOUNT_CONSUMERKEY="12" -e TWITTER_ACCOUNT_CONSUMERSECRET="34" -e TWITTER_ACCOUNT_ACCESSTOKEN="56" -e TWITTER_ACCOUNT_ACCESSTOKENSECRET="78" twibot
* docker attach mybot
* Ctrl P+Q will detach from session

