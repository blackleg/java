#!/usr/bin/env bash
source .travis/utils.sh

if isDeployable; then
	openssl aes-256-cbc -K $encrypted_65fd749ede06_key -iv $encrypted_65fd749ede06_iv -in codesigning.asc.enc -out codesigning.asc -d
	gpg --fast-import codesigning.asc
fi
