#!/bin/bash

# Clean Docker environment script for macOS

echo -e "\033[1;36mStopping containers...\033[0m"
docker-compose down

echo -e "\033[1;36mPruning system...\033[0m"
docker system prune -a -f  # -f flag forces pruning without confirmation

echo -e "\n\033[1;33mRemaining containers:\033[0m"
docker ps -a

echo -e "\n\033[1;33mRemaining images:\033[0m"
docker images

echo -e "\n\033[1;32mDocker cleanup complete!\033[0m"