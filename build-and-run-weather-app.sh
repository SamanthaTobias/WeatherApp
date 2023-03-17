#!/bin/bash

# Build the Maven project
mvn clean
mvn package

# Build the Docker image
docker build -t weather-app .

# Run the Docker container
docker run --rm --name weather-app --network my-network -p 9020:9020 weather-app
