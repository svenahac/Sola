#!/bin/bash

ls -l ~/ > vsebina.txt

cat vsebina.txt

echo "Direktoriji so:"
egrep "^d" vsebina.txt

echo

echo "Vnosi, ki se zaključijo s .sh:"
egrep ".sh$" vsebina.txt

echo

echo "Vse datoteke velikosti 0 bajtov:"
egrep '^-' vsebina.txt | egrep -w '0' 