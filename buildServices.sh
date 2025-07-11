#!/bin/bash

# Define services in build order
services=(
  "GameHub_Service_Discovery"
  "GameHub_ServiceOne" 
  "GameHub_ServiceTwo"
  "GameHub_Service_Gateway"
)

# Build each service
for service in "${services[@]}"; do
  echo -e "\n\033[1;36mBuilding ${service}...\033[0m"
  cd "${service}" || { echo -e "\033[1;31mError entering ${service} directory\033[0m"; exit 1; }
  
  gradle clean build
  
  if [ $? -ne 0 ]; then
    echo -e "\033[1;31mBuild failed for ${service}\033[0m"
    exit 1
  fi
  
  cd ..
  echo -e "\033[1;32m${service} built successfully!\033[0m"
done

echo -e "\n\033[1;35mAll services built successfully!\033[0m"
