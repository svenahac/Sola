#include <stdio.h>

int main() {
    char notAString[3] = {'b', 'l', 'a'};
    char string[4] = {'b', 'l', 'a', '\0'};

    char stringA[10] = {'b', 'l', 'a', '\0'};
    char stringB[] = {'b', 'l', 'a', '\0'};
    char stringC[10] = "bla";

    printf("%s\n", stringC);
}