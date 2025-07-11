#!/bin/bash

# Build all services
./gradlew :discovery:build
./gradlew :jogo-service:build
./gradlew :conquista-service:build
./gradlew :gateway:build

# Build Docker images
docker-compose build