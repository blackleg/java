#!/usr/bin/env bash

source .travis/utils.sh

if isDeployable; then
	mvn -P release --settings .travis/settings.xml install
else
	mvn install
fi
