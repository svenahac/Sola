#!/bin/bash
echo Vnesi katero operacijo želiš izvesti +,-,X?
read operacija

echo vnesi Števila: 
read stevila

vsota () {
    local rezultat=0
    for stevilo in $stevila
    do
        rezultat=$(($rezultat + $stevilo))
    done
    echo $rezultat
}

razlika () {
    local rezultat=0
    for stevilo in $stevila
    do
        rezultat=$(($rezultat - $stevilo))
    done
    echo $rezultat
}

zmnozek () {
    local rezultat=1
    for stevilo in $stevila
    do
        rezultat=$(($rezultat * $stevilo))
    done
    echo $rezultat
}
if [ $# -lt 10 ]
then
    if [ $operacija == '+' ]
    then
        vsota $stevila
    elif [ $operacija == '-' ]
    then
        razlika $stevila
    elif [ $operacija == 'X' ]
    then
        zmnozek $stevila
    else 
        echo Napačna operacija
    fi
else
    echo "Podanih je preveč argumentov."
fi