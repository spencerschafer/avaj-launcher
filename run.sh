#!/bin/bash
find . -name src/*.java > sources.txt
javac -sourcepath . @sources.txt
#java avaj.weather.Simulator avaj/scenario.txt


#different option
#!/bin/sh
#javac -d . com/avaj/**/*.java
#java -cp . com.avaj.simulator.Simulator $@
