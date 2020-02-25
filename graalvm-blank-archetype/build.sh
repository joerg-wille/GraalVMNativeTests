#!/bin/bash

docker run --rm \
           -v "$PWD":/usr/src \
           -v "$HOME/.m2":/root/.m2 \
           -w /usr/src \
           oracle/graalvm-ce:20.0.0 \
           ./mvnw package -Pgraal
