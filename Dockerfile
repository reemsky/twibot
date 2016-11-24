FROM anapsix/alpine-java
MAINTAINER reemsky
COPY target/simple-twitter-bot-1.0.jar /home/bot.jar
CMD ["java","-jar","/home/bot.jar"]
