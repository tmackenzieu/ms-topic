#!/bin/bash

set -e

die () {
	echo "Usage: /app/entrypoint.sh"
	exit 1
}

echo "Running..."

#echo ${ENVIRONMENT}
#bash environment.sh || status=1

exec java -Dspring.profiles.active=${ENVIRONMENT} -Djava.security.egd=file:/dev/./urandom -jar /app/app.jar
