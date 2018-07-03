#!/usr/bin/env bash
echo "refresh  at `date +%F-%H-%M.%N` "
./gradlew tomcatStop   >>/tmp/auto_deploy_log &&
./gradlew tomcatRun  >>/tmp/auto_deploy_log
