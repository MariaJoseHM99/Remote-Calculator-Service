FROM ubuntu:20.04
WORKDIR /server
RUN apt-get update
RUN apt-get install -y ruby \
    bundler \
    ri \
    ruby-dev
RUN gem install thrift
EXPOSE 8080
CMD ["ruby", "CalculatorServer.rb"]