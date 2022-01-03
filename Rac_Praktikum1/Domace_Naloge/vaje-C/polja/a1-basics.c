#include <stdio.h>

int main() {
    int numbers[5];
    
    numbers[0] = 7;
    numbers[1] = 12;
    numbers[2] = 2;
    numbers[3] = 21;
    numbers[4] = 40;

    printf("First element of numbers: %i\n", numbers[0]);

    int otherNumbers[5] = {7, 12, 2, 21, 40};
    for (int i = 0 ; i < 5 ; i++) {
        printf("%i ", otherNumbers[i]);
    }
    printf("\n");

    int uninitializedArray[5];
    for (int i = 0 ; i < 5 ; i++) {
        printf("%i ", uninitializedArray[i]);
    }
    printf("\n");
}