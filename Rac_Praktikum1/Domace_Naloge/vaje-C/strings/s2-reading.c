#include <stdio.h>

int main() {
    char word[20];
    printf("Enter your name: ");
    /*
        fgets reads multiple words (unlike scanf)
        scanf("%s", word);
    */
    fgets(word, sizeof(word), stdin);
    printf("%s\n", word);
}