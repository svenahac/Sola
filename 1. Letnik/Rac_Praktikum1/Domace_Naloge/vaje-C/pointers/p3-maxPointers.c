#include <stdio.h>

int* max(int* numA, int* numB);

int main() {
    int numberA = 8;
    int numberB = 5;
    printf("[main] numberA: %i\n", numberA);
    printf("[main] numberB: %i\n", numberB);

    int *pNumberA = &numberA;
    int *pNumberB = &numberB;

    printf("[main] pNumberA: %p\n", pNumberA);
    printf("[main] pNumberB: %p\n", pNumberB);

    int *pBigger = max(pNumberA, pNumberB);
    printf("[main] pBigger: %p\n", pBigger);
    printf("[main] *pBigger: %i\n", *pBigger);

    numberA++;
    printf("[main] CHANGE TO numberA!!\n");

    printf("[main] pBigger: %p\n", pBigger);
    printf("[main] *pBigger: %i\n", *pBigger);

}

int* max(int* numA, int* numB) {
    printf("[max] numA (pointer): %p\n", numA);
    printf("[max] numB (pointer): %p\n", numB);
    printf("[max] *numA (value): %i\n", *numA);
    printf("[max] *numB (value): %i\n", *numB);
    if (*numA > *numB) {
        return numA;
    } else {
        return numB;
    }

}