#!/bin/bash
cd src
find . -name \*.java > sources.txt
javac -sourcepath . @sources.txt
java main avaj/scenario.txt
