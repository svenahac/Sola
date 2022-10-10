#!/bin/bash

razlika () {
    raz=$(( $2 - $1 ))
    echo $raz
}

zmnozek () {
    rez=$(( $1 * $2 ))
    echo $rez
}

vsota () {
    skupaj=0
    for ((i=$1;i<=$2;i++));
    do
        if (($i % 2 == 0))
        then
            skupaj=$((skupaj + $i ))
        fi
    done
    echo $skupaj

}
if [ $# == 2 ]
then
    if [[ "$1" =~ ^[0-9]+$ ]] && [[ "$2" =~ ^[0-9]+$ ]]
    then
        if [ $1 -lt $2 ]
        then
            razlika $1 $2
            zmnozek $1 $2
            vsota $1 $2
        else
            echo "Napaka: Prvo stevilo ni manjse od drugega."
        fi
    else
        echo "Napaka: Podana argumenta nista stevili. Podaj dve stevili."
    fi
else
    echo "Napaka: Stevilo podanih elementov ni enako 2."
fi