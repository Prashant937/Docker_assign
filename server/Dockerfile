FROM openjdk AS build

WORKDIR /

LABEL "Name"="Prashant"

ADD ./server.java .

RUN javac server.java && mkdir server-data

CMD ["java", "S"]
