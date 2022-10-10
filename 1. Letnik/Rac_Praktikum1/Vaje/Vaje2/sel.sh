#!/bin/bash

names='Alen Marko Aleks Quit'

PS3='Izberi osebo: '

select name in $names
do
    if [ $name == 'Quit' ]
    then
        break
    fi

    echo Hello $name
done

echo Nasvidenje