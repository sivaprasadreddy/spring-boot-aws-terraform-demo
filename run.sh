#!/bin/bash

declare project_dir=$(dirname "$0")
declare dc_api=${project_dir}/docker-compose.yml
declare services="random-jokes"

function build_api() {
    ./mvnw clean package -DskipTests
}

function start() {
    build_api
    echo "Starting ${services} docker containers...."
    docker-compose -f "${dc_api}" up --build --force-recreate -d ${services}
    docker-compose -f "${dc_api}" logs -f ${services}
}

function stop() {
    echo "Stopping ${services} docker containers...."
    docker-compose -f "${dc_api}" stop
    docker-compose -f "${dc_api}" rm -f
}

function restart() {
    stop
    sleep 5
    start
}

function dockerPush() {
  ./mvnw spring-boot:build-image -DskipTests -Dspring-boot.build-image.imageName=sivaprasadreddy/random-jokes
  docker push sivaprasadreddy/random-jokes
}

action="start"

if [[ "$#" != "0"  ]]
then
    action=$*
fi

eval "${action}"
