#!/usr/bin/env bash

function isDeployable {
	if [ "$TRAVIS_PULL_REQUEST" == "false" ] && ( [ "$TRAVIS_BRANCH" = 'master' ] || [ "$TRAVIS_BRANCH" = 'devel' ] || [ ! -z "$TRAVIS_TAG" ] ); then
	return 0;
else
	return 1;
fi
}

function isDevelBranch {
	if  [ "$TRAVIS_BRANCH" = 'devel' ]; then
		return 0;
	else
		return 1;
	fi
}

function isTagRelease {
	echo "##### Test Tag Release ####"
	echo $TRAVIS_BRANCH;
	echo $TRAVIS_TAG;
	#if  [ "$TRAVIS_BRANCH" = 'master' ] && ; then
	#	return 0;
	#else
	#	return 1;
	#fi
	return 1;
}
