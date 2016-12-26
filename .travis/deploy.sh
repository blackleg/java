#!/usr/bin/env bash

source .travis/utils.sh

if isDeployable && isDevelBranch; then
	mvn -P release --settings .travis/settings.xml deploy
fi
