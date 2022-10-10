#include <stdio.h>
/*
    NAL: napiši program, ki od uporabnika sprejme 2 števili.
    Implementiraj funckijo "max", ki ji podamo te števili, ta pa nam vrne večjo.
    Večje število izpiši.

    IZPIS:
    Vpisi stevilo a: 5
    Vpisi stevilo b: 8
    Vecje stevilo je: 8
*/
/*
    deklaracija funkcije
*/
int max(int numberA, int numberB);
/*
    inicializacije funkcij
*/
int main() {
    // rezervirali prostor za uporabnikove vnose
    int inputA;
    int inputB;

    // shrani prvi vnos
    printf("Vpisi stevilo a: ");
    scanf("%i", &inputA);

    // shrani drugi vnos
    printf("Vpisi stevilo b: ");
    scanf("%i", &inputB);

    // kliči max in izpiši rezultat
    int bigger = max(inputA, inputB);
    printf("Vecje stevilo je: %i\n", bigger);
}

int max(int numberA, int numberB) {
    if (numberA >= numberB) {
        return numberA;
    } else {
        return numberB;
    }
}