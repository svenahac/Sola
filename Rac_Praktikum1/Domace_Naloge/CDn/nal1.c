#include<stdio.h>

int main(){
    int skrSt;
    printf("Vnesi skrivno stevilko: ");
    scanf("%i", &skrSt);
    int guess = -1;
    int biggest = 2147483647;
    int smallest = 0;
    while(guess != skrSt){
        guess = ((biggest-smallest)/2 + smallest);
        printf("Racunalnikov poskus je: %i\n", guess);
        if(guess > skrSt){
            printf("Uporabnikova stevilka je nizja od poskusa \n");
            biggest = guess - 1;
        } else if(guess < skrSt){
            printf("Uporabnikova stevilka je visja od poskusa \n");
            smallest = guess + 1;
        } else if(guess == skrSt){
            printf("Pravilno! Stevilka je bila: %i\n", skrSt);
        }
    }
}