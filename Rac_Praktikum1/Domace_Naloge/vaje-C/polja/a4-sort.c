#include <stdio.h>
#include <stdlib.h>

void printArray(int array[], int length);
void sort(int array[], int length);
void initRandom(int array[], int length);

const int MAX_RANDOM_NUMBER = 1000;

int main() {
    int numbers[10];
    int numbersLength = 10;
    initRandom(numbers, numbersLength);
    printArray(numbers, numbersLength);
    sort(numbers, numbersLength);
    printArray(numbers, numbersLength);
}

void sort(int array[], int length) {
    for (int i = 0 ; i < length ; i++) {
        for (int j = 0 ; j < length - 1 - i ; j++) {
            if (array[j] > array[j + 1]) {
                //swap
                int tmp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = tmp;
            }
        }
    }
}

void initRandom(int array[], int length) {
    for (int i = 0 ; i < length ; i++) {
        array[i] = rand() % MAX_RANDOM_NUMBER;
    }
}

void printArray(int array[], int length) {
    printf("[ ");
    for (int i = 0 ; i < length ; i++) {
        printf("%i ", array[i]);
    }
    printf("]\n");
}
