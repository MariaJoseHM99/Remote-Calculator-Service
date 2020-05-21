FROM ubuntu:20.04
WORKDIR /client
RUN apt-get update
RUN apt-get install -y openjdk-8-jdk
EXPOSE 8080
CMD javac -cp libthrift-0.13.0.jar:slf4j-api-1.7.30.jar:slf4j-nop-1.7.30.jar:gen-java -encoding UTF-8 CalculatorClient.java; java -cp libthrift-0.13.0.jar:slf4j-api-1.7.30.jar:slf4j-nop-1.7.30.jar:gen-java:. CalculatorClient
