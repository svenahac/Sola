#include <stdio.h>

int main() {
    int number = 10;
    printf("VARIABLE \t VALUE\n");
    printf("number   \t %i\n", number);
    printf("&number  \t %p\n", &number);

    int *pNumber = &number;
    printf("pNumber  \t %p\n", pNumber);
    printf("*pNumber \t %i\n", *pNumber);
}