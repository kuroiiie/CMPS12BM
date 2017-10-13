#Makefile
#A makefile for list.c
CC = gcc
CFLAGS = -std=c99 -Wall -Werror -Wfatal-errors -g
OBJS = list.o
OUTPUT = list
HEADERS = minunit.h

${OUTPUT}: ${OBJS}
	${CC} $< -o ${OUTPUT}

%.0: %.c ${HEADERS}
	${CC} -c ${CFLAGS} $<

clean:
	rm -f *.o

spotless: clean
	rm -f ${OUTPUT}

test: ${OUTPUT}
	valgrind ./${OUTPUT}

.PHONY: clean spotless test