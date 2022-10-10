#!/bin/bash
# Aritmeticne operacije

let a=2+3
echo a: $a

let "b = 4 + 5"
echo b: $b

let a++
echo a: $a

let c=4*5
echo c: $c

let "d = $c - 2"
echo d: $d

let d--
echo d: $d

let e=20/4
echo e: $e

let f=20%3
echo f: $f