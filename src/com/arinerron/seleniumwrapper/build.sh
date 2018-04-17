#!/bin/sh

rm -rf build > /dev/null 2>&1
mkdir build

cd ./bin
jar cvf seleniumwrapper.jar `find . -name "*.class" | grep "arinerron" | grep -v "\\$1"`
mv ./seleniumwrapper.jar ../build/

cd ..
exit 0
