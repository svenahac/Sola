#include <stdio.h>
#include <stdlib.h>

int main() {
    /* Komentar */
    printf("Vnesi stevilo: ");
    int stevilo;
    scanf("%d", &stevilo);
    printf("Vnesel si %d\n", stevilo);
    printf("Hello world! \n");
    const char *s = getenv("DESKTOP_SESSION");
    printf("env variable: %s\n", s);


    return 0;
}