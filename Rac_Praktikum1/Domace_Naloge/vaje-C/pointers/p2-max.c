#include <stdio.h>

int max(int numA, int numB);

int main() {
    int numberA = 8;
    int numberB = 5;
    printf("[main] Adress of numberA: %p\n", &numberA);
    printf("[main] Adress of numberB: %p\n", &numberB);
    
    int bigger = max(numberA, numberB);
    printf("[main] Address of bigger: %p\n", &bigger);
    printf("[main] Bigger number is: %i\n", bigger);
    
    numberA++;
    printf("[main] CHANGE TO numberA!!\n");

    printf("[main] Bigger number is: %i\n", bigger);
}

int max(int numA, int numB) {
    printf("[max] Adrees of numA in max: %p\n", &numA);
    printf("[max] Adrees of numB in max: %p\n", &numB);
    if (numA > numB) {
        return numA;
    } else {
        return numB;
    }
}