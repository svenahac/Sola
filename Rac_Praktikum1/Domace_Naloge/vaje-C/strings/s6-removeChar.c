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
    int index = 0;
    while (string[index] != '\0') {
        if (string[index] == toRemove) {
            removeCharAt(string, index);
        } else {
            index++;
        }
    }
    
}

void removeCharAt(char string[], int index) {
    for (int i = index ; i < strlen(string) ; i++) {
        string[i] = string[i + 1];
    }
}