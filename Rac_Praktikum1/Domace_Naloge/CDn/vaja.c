#include <stdio.h>

int main(){
    int stevila;
    printf("Koliko stevil zelis vnesti: ");
    scanf("%i", &stevila);
    int array[stevila];
    for (int i = 1; i <= stevila; i++){
        printf("Vnesi stevilo %i: ", i);
        scanf("%i", &array[i-1]);
    }
    for (int i = 0; i < stevila; i++){
        printf("%i ", array[i]);
    }
    
}