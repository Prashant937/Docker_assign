FROM openjdk AS build

WORKDIR /

LABEL "Name"="Prashant"

ENV IP=180.10.0.10

ADD ./client.java .

RUN javac client.java 

CMD java C ${IP}