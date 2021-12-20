#include <stdio.h>

void copyString(char from[], char to[]);

int main() {
    char stringA[20] = "Bla bla bla bla!";
    char stringB[20];
    
    copyString(stringA, stringB);

    printf("%s\n", stringB);
}

void copyString(char from[], char to[]) {
    int index = 0;
    while (1) {
        to[index] = from[index];
        if (from[index] == '\0') break;

        index++;
    }
}