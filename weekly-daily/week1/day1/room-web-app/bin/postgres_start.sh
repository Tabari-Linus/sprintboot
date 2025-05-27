#!/usr/bin/env bash
##set -euo pipefail
#mkdir -p "./dat"
#sudo apt-get update && sudo apt-get install -y postgresql-client && sudo apt-get install -y httpie

docker run -d --rm --name pg-docker \
-e POSTGRES_PASSWORD=postgres \
-e POSTGRES_DB=local \
-p 5332:5432 \
postgres:17.2
#
#docker run --rm -d --name rabbit-docker \
#-p 5671:5671 \
#-p 5672:5672 \
#-p 15672:15672 \
#rabbitmq:4.0.5-management