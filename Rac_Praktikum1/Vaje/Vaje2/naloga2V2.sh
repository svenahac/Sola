#!/bin/bash

if [ $# -le 1 ] || [ $# -gt 9 ]
then
    echo "Napaka: Vneseš lahko max 9 števil."
    exit 1
fi

vsota () {
    local rezultat=0
    for stevilo in $@
    do
        rezultat=$(($rezultat + $stevilo))
    done
    echo Vsota: $rezultat
}

razlika () {
    local rezultat=0
    for stevilo in $@
    do
        rezultat=$(($rezultat - $stevilo))
    done
    echo Razlika: $rezultat
}

zmnozek () {
    local rezultat=1
    for stevilo in $@
    do
        rezultat=$(($rezultat * $stevilo))
    done
    echo Zmnozek: $rezultat
}

operacije='Sestevanje Odstevanje Mnozenje Exit'

PS3='Izberi operacijo: '

select op in $operacije
do
    if [ $op == 'Sestevanje' ]
    then
        vsota $@
    elif [ $op == 'Odstevanje' ]
    then
        razlika $@
    elif [ $op == 'Mnozenje' ]
    then
        zmnozek $@
    elif [ $op == 'Exit' ]
    then
        break
    else
        echo "Napačna operacija"
    fi
done