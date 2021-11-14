#!/bin/bash
dir=$(pwd)
os=$(uname -a)
if [ $# -gt 0 ]
then
    if [ -e $1 ]
    then
        echo "Dokument že obstaja."
        rm $1
        echo "Dokument je bil izbrisan."
    else
        echo "Dokument še ne obstaja"
    fi
    touch $1
    echo "Uporabniško ime:" $USER >> $1
    echo "Delovnni direktorij: $dir ">> $1
    echo "Informacije o OS: $os ">> $1
else
    echo "Napaka: Ni podanih argumentov."
    exit 1
fi