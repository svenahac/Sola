#!/bin/bash

N=$1

pra () {
for ((sg=2; sg<=$1; sg++))
do
    count=0
     for ((sm=1; sm*sm<=sg/2; sm++))
     do
        
         if(( sg % sm == 0 ))
         then
             ((count ++))
         fi
     done
    if [ $count -eq 1 ]
    then
        echo $sg je prašt
    fi
    
done
}

pra $1
