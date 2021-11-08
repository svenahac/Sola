#!/bin/bash

var_spremeni () {
    local var1='local 1'
    echo Znotraj funkcije: var1 je $var1
    echo Znotraj funkcije: var2 je $var2
    var1='ponovno spremenjena'
    var2='var2 ponovno spremenjena'
}

var1='global 1'
var2='global 2'

echo Pred klicem funkcije: var1 je $var1
echo Pred klicem funkcije: var2 je $var2

var_spremeni

echo Po klicu funkcije: var1 je $var1
echo Po klicu funkcije: var2 je $var2
