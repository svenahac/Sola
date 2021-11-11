#!/bin/bash

razlika () {
    raz=$(( $2-$1 ))
    echo $raz
}

zmnozek() {
    rez=$(($1*$2))
    echo $rez
}

vsota () {
    skupaj=0
    for ((i=$1;i<=$2;i++));
    do
        skupaj=$((skupaj + $i ))
    done
    echo $skupaj

}

#razlika $1 $2
zmnozek $1 $2
#vsota $1 $2