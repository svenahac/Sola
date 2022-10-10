#include <stdio.h>

void displayString(char string[]);

int main(){

    char input[50];
    printf("enter string: ");
    fgets(input, sizeof(input), stdin);

    displayString(input);

}

void displayString(char string[]) {
    int i = 0;
    while(1){
        if (string[i] == '\0') break;

        printf("%c", string[i]);

        i++;
    }
}