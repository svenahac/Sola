#!/bin/bash

I=$1
J=$2
dat=$3

if [ $I -lt 0 ] || [ $J -lt 0 ]
then
    echo "Napaka: Samo pozitivna števila"
    exit 1
fi

if [ $I == "-h" ] || [ $J == "-h" ]
then
    echo "Vpiši dve števili, ki sta pozitivni."
    exit 0
fi

for ((i=1;i<I+1;i++));
do
    if [ -d $i ]
    then
        echo "Napaka: L nerd, je direktorij"
        exit 1
    else
        mkdir $i
    fi
    for ((j=1;j<J+1;j++));
    do
        if [ -e $i/$j ]
        then
            echo "Napaka: L nerd, je file"
            exit 1
        fi
        if [ $# -eq 3 ] && [ -f $dat ]
        then
            cp $dat $i/$dat
        else
            touch $i/$j
        fi
    done
done