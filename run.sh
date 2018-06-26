#!/bin/bash
find src -name \*.java > sources.txt
javac -sourcepath . @sources.txt
cd src
java Main ../resources/tests/valid/scenario.txt
rm *.class
rm ../sources.txt
