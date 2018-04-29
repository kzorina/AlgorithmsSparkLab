# Version: 0.0.1
FROM p7hb/docker-spark:2.2.0
MAINTAINER Zorina Kateryna "ekaterina.zorina95@gmail.com"
RUN echo 'Hi, container have bin installed successfully'
ADD followers.txt /root/
ADD SixAlgosSpark-1.0-SNAPSHOT-jar-with-dependencies.jar /root/
CMD spark-submit --class SixAlgosSpark.App --master local SixAlgosSpark-1.0-SNAPSHOT-jar-with-dependencies.jar followers.txt
EXPOSE 80
