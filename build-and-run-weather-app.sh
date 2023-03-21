#!/bin/bash

# Build the Maven project
mvn clean
mvn package

# Build the Docker image
docker build -t weather-app .

# Check if my-network exists, create it if it doesn't
if ! docker network inspect my-network >/dev/null 2>&1; then
    docker network create my-network
fi

# Run the Docker container
docker run --rm --name weather-app --network my-network -p 9020:9020 -e SERVER_PORT=9020 weather-app
