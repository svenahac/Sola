#include <stdio.h>

void displayString(char string[]);

int main() {
    char input[50];
    printf("Enter your name: ");
    fgets(input, sizeof(input), stdin);
    displayString(input);
}

void displayString(char string[]) {
    int index = 0;
    while (string[index] != '\0') {
        printf("%c", string[index]);
        index++;
    }
}
