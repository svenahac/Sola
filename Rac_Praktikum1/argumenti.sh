#!/bin/bash
# Prikaz delovanja argumentov ukazne vrstice

cp $1 $2

# Preverimo vrednosti

echo Podrobnosti za $2
ls -l $2

echo $0
echo Število argumentov podanih v skripti: $#
echo Vsi argumenti, ki so podani skripti: $@
echo Izhodno stanje predhodnega procesa: $?
echo ID trenutne skripte: $$
echo Uporabnisko ime uporabnika, ki trenutno poganja skripto: $USER
echo Ime gostitelja na katerem teče skripta: $HOSTNAME
echo Koliko časa teče skripta: $SECONDS
echo Naključno število: $RANDOM
echo Trenutna številka vrstice: $LINENO