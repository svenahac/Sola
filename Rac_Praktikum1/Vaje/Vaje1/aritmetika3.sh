#!/bin/bash
# Aritmetika z dvojnimi oklepaji

a=$(( 4 + 5  ))
echo a: $a

b=$((7+4))
echo b: $b

c=$((a+3))
echo c: $c

d=$(($b+1))
echo d: $d

((b+=4))
echo $b