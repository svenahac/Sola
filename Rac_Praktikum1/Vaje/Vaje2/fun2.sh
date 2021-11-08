#!/bin/bash

lines_in_file() {
    cat $1 | wc -l
}

st_vrstic=$( lines_in_file $1 )

echo Datoteka $1 ima $st_vrstic vrstic