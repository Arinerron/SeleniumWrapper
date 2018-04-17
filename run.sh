#!/bin/sh

# remove previously compiled files
rm -rf ./bin/ > /dev/null 2>&1
mkdir bin

# compile wrapper
set -e
cd ./src/
javac -cp .:../lib/* -d ../bin/ ./Main.java ./com/arinerron/seleniumwrapper/*.java

# build to jar
cd ../
sh build.sh > /dev/null

# run main
cd ./bin/
clear
java -cp .:../lib/* Main

# cleanup
cd ../
exit
