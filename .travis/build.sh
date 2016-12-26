#!/usr/bin/env bash

source .travis/util.sh

if isDeployable; then
	mvn -P release install
else
	mvn install
fi
