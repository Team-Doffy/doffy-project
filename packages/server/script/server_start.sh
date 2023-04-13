#!/usr/bin/env bash
cd /home/ubuntu/build
sudo nohup java -jar server-SNAPSHOT.jar > /dev/null 2> /dev/null < /dev/null &