#include <stdio.h>
#include <stdlib.h>

int main(){
    srand(time(0));
    int guess;
    // LEVEL 1
    int guesses = 5;
    printf("LEVEL 1:\n");
    printf("Guess the number between 1-10:\n");
    int first = rand() % 10 + 1;
    for (int i = 1; i <= 5; i++){
        printf("Guess %i: ", i);
        scanf("%i", &guess);

        if (first > guess) {
            printf("Your guess is smaller than the number.\n");
        } else if (first < guess) {
            printf("Your guess is bigger than the number.\n");
        }

        if(guess == first){
            printf("Congrats, you have completed level 1!\n");
            break;
        } else if(guess != first && i == 5){
            printf("Game over!");
            exit(0);
        } else {
            guesses--;
            printf("You have %i guesses left.\n", guesses);
        }
    }
    // LEVEL 2
    int guesses2 = guesses + 10;
    printf("LEVEL 2:\n");
    printf("Guess the number between 1-100:\n");
    int second = rand() % 100 + 1;
    for (int i = 1; i <= guesses + 10; i++){
        printf("Guess %i: ", i);
        scanf("%i", &guess);
        
        if (second > guess){
            printf("Your guess is smaller than the number.\n");
        } else if(second < guess){
            printf("Your guess is bigger than the number.\n");
        }

        if(guess == second){
            printf("Congrats, you have completed level 2!\n");
            break;
        } else if(guess != second && i == guesses + 10){
            printf("Game over!");
            exit(0);
        } else {
            guesses2--;
            printf("You have %i guesses left.\n", guesses2);
        }
    }
    // LEVEL 3
    int guesses3 = guesses2 + 15;
    printf("LEVEL 3:\n");
    printf("Guess the number between 1-500:\n");
    int third = rand() % 500 + 1;
    for (int i = 1; i <= guesses2 + 15; i++){
        printf("Guess %i: ", i);
        scanf("%i", &guess);
        
        if (third > guess){
            printf("Your guess is smaller than the number.\n");
        } else if(third < guess){
            printf("Your guess is bigger than the number.\n");
        }

        if(guess == third){
            printf("Congrats, you have completed level 3!\n");
            break;
        } else if(guess != third && i == guesses2 + 15){
            printf("Game over!");
            exit(0);
        } else {
            guesses3--;
            printf("You have %i guesses left.\n", guesses3);
        }
    }
    // LEVEL 4
    int guesses4 = guesses + 20;
    printf("LEVEL 4:\n");
    printf("Guess the number between 1-1000:\n");
    int fourth = rand() % 100 + 1;
    for (int i = 1; i <= guesses3 + 20; i++){
        printf("Guess %i: ", i);
        scanf("%i", &guess);
        
        if (fourth > guess){
            printf("Your guess is smaller than the number.\n");
        } else if(fourth < guess){
            printf("Your guess is bigger than the number.\n");
        }

        if(guess == fourth){
            printf("Congrats, you have completed the game!\n");
            break;
            return(0);
        } else if(guess != fourth && i == guesses3 + 20){
            printf("Game over!");
            exit(0);
        } else {
            guesses4--;
            printf("You have %i guesses left.\n", guesses4);
        }
    }
    
}