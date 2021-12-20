#include <stdio.h>
#include <string.h>

void removeChars(char string[], char toRemove);
void removeCharAt(char string[], int index);

int main() {
    char string[20] = "bla bla bla";
    removeChars(string, 'b');
    printf("%s\n", string);
}

void removeChars(char string[], char toRemove) {
    int i = 0;
    while (1) {

        if (string[i] == '\0') break;

        if (string[i] == toRemove) {
            removeCharAt(string, i);
        }        
        i++;
    }
}

void removeCharAt(char string[], int index) {
    for (int i = index; i < strlen(string); i++) {
        string[i] = string[i + 1];
    }
}