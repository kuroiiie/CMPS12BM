#Makefile
#Makefile for asg8
JAVASRC    = xref.java auxlib.java Tree.java Queue.java
SOURCES    = ${JAVASRC} Makefile
ALLSOURCES = ${SOURCES}
MAINCLASS  = xref
CLASSES    = ${patsubst %.java, %.class, ${JAVASRC}}

all: ${CLASSES}

%.class: %.java
	javac -Xlint $<

clean:
	rm -f *.class

test: all
	java xref test.txt
	
testd: all
	java xref -d test.txt

.PHONY: clean all test
