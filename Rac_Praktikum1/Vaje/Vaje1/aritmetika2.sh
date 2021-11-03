#!/bin/bash
# Aritmetika z uporabo ukaza expr

expr 4 + 6 #10

expr "4 + 6" #4 + 6

expr 4+6 #4+6

expr 10 - 5

expr 2 \* 3

expr 10 / 2

expr 20 % 3

a=$( expr 20 % 3 )
echo a: $a