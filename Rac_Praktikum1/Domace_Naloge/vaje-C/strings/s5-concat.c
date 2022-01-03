#include <stdio.h>

void concat(char arrA[], char arrB[], char final[]);

int main() {
    char stringA[20] = "Hello ";
    char stringB[20] = "world!";
    char out[40];

    concat(stringA, stringB, out);

    printf("%s\n", out);
}

void concat(char arrA[], char arrB[], char final[]) {
    int index = 0;
    int indexFinal = 0;
    while (arrA[index] != '\0') {
        final[indexFinal] = arrA[index];
        index++;
        indexFinal++;
    }
    index = 0;
    while (1) {
        final[indexFinal] = arrB[index];
        if (arrA[index] == '\0') {
            break;
        }
        index++;
        indexFinal++;
    }
}