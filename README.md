
Simple twitter bot that posts message from application.yml every provided period.

### Setup ###

Default application parameters are located in application.yml
There are several ways to run the application:

## Maven 
To run with default parameters:
* mvn package spring-boot:run

To run with custom parameters:
* mvn package spring-boot:run *to be added later*

## Java
To run with default parameters:
* java -jar target/simple-twitter-bot-1.0.jar

To run with custom parameters:
* java -jar target/simple-twitter-bot-1.0.jar 
--twitter.cron="*/10 * * * * *" 
--twitter.account.consumerKey="aaa" 
--twitter.account.consumerSecret="bbb" 
--twitter.account.accessToken="ccc" 
--twitter.account.accessTokenSecret="ddd"

## Docker:
* docker build -t twibot .

To run with default parameters:
* docker run -dti --name mybot twibot

To run with custom parameters:
* docker run -dti --name mybot -e TZ=Europe/Riga -e TWITTER_CRON="*/10 * * * * *" -e TWITTER_ACCOUNT_CONSUMERKEY="12" -e TWITTER_ACCOUNT_CONSUMERSECRET="34" -e TWITTER_ACCOUNT_ACCESSTOKEN="56" -e TWITTER_ACCOUNT_ACCESSTOKENSECRET="78" twibot
* docker exec -ti mybot /bin/bash
