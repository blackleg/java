#!/usr/bin/env bash

source .travis/utils.sh

if isDeployable; then
	mvn -P release install
else
	mvn install
fi
