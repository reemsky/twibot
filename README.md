
Simple twitter bot that posts message from application.yml every provided period.

### Setup ###

Default application parameters are located in application.yml
There are several ways to run the application:

## Maven 
With default parameters:
* mvn package spring-boot:run

With parameters
* mvn package spring-boot:run *to be added later*

## Java
* java -jar target/simple-twitter-bot-1.0.jar 
* java -jar target/simple-twitter-bot-1.0.jar 
--twitter.cron="*/10 * * * * *" 
--twitter.account.consumerKey="aaa" 
--twitter.account.consumerSecret="bbb" 
--twitter.account.accessToken="ccc" 
--twitter.account.accessTokenSecret="ddd"

## Docker:
* docker build -t twibot .
* docker run -dti --name mybot -e TZ=Europe/Riga -e TWITTER_CRON="*/10 * * * * *" -e TWITTER_ACCOUNT_CONSUMERKEY="12" -e TWITTER_ACCOUNT_CONSUMERSECRET="34" -e TWITTER_ACCOUNT_ACCESSTOKEN="56" -e TWITTER_ACCOUNT_ACCESSTOKENSECRET="78" twibot
* docker exec -ti mybot /bin/bash
