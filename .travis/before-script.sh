#!/usr/bin/env bash
source .travis/utils.sh

if isSignable; then
	openssl aes-256-cbc -K $encrypted_65fd749ede06_key -iv $encrypted_65fd749ede06_iv -in .travis/codesigning.asc.enc -out .travis/codesigning.asc -d
	gpg --fast-import .travis/codesigning.asc
fi
