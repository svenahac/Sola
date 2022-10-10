#include <stdio.h>

void printArray(int array[], int length);

int main() {
    int numbers[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    int sizeOfArray = sizeof(numbers);
    printf("Size of array numbers: %i\n", sizeOfArray);

    int sizeOfElement = sizeof(numbers[0]);
    printf("Size of one element: %i\n", sizeOfElement);

    int arrayLength = sizeOfArray / sizeOfElement;
    printf("Length of array: %i\n", arrayLength);

    printArray(numbers, arrayLength);
}

/*
    [ x, y, z, ...]
*/
void printArray(int array[], int length) {
    printf("[ ");
    for (int i = 0 ; i < length ; i++) {
        printf("%i ", array[i]);
    }
    printf("]\n");
}


