#!/bin/bash
# Vprašajmo uporabnika po uporabniškem imenu in geslu

read -p 'Uporabnisko ime: ' username
read -sp 'Geslo: ' pass
echo
echo Hvala $username zdaj imamo vaše podatke o vpisu
echo Vase geslo je $pass