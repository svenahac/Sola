#include <stdio.h>

void extremeValues(int array[], int length, int* max, int* min);

int main() {
    int numbers[7] = {23, 65, 4, 86, 345, 121, 34};
    int max;
    int min;
    extremeValues(numbers, 7, &max, &min);
    printf("Max: %i\n", max);
    printf("Min: %i\n", min);
}

void extremeValues(int array[], int length, int* max, int* min) {
    int maxElement = array[0];
    int minElement = array[0];
    for (int i = 0 ; i < length ; i++) {
        if (array[i] > maxElement) {
            maxElement = array[i];
        }
        if (array[i] < minElement) {
            minElement = array[i];
        }
    }
    *max = maxElement;
    *min = minElement;
}