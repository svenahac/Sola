#include <stdio.h>
#include <stdbool.h>
#include <string.h>

int main() {
    printf("Let's play FizzBuzz!\n");
    /*
        main counter of the game
    */
    int counter = 1;
    /*
        as long as this is true we are playing the game
    */
    bool playing = true;
    /*
        variable that defines whose turn is it
        0 = computer
        1 = player
    */
    int playerTurn = 0;
    /*
        both string and int versions of player input
    */
    int intPlayerInput;
    char stringPlayerInput[20];

    /*
        main game loop (as long as playing is set to true)
    */
    while (playing) {
        /*
            check whose turn is it
        */
        if (playerTurn == 0) { // computer's turn
            /*
                check devisions and print the answer
            */
            if (counter % 3 == 0 && counter % 7 == 0) {
                printf("Fizz Buzz\n");
            } else if (counter % 3 == 0) {
                printf("Fizz\n");
            } else if (counter % 7 == 0) {
                printf("Buzz\n");
            } else {
                printf("%i\n", counter);
            }
        } else { // our turn
            /*
                get and check out input
            */
            if (counter % 3 == 0 && counter % 7 == 0) {
                /*
                    input string
                */
                scanf("%s", stringPlayerInput);
                /* 
                    check if string is correct
                */
                if (strcmp(stringPlayerInput, "Fizz Buzz") != 0) {
                    playing = false;
                    printf("Oops, that the wrong answer! GAME OVER!\n");
                }
            } else if (counter % 3 == 0) {
                /*
                    input string
                */
                scanf("%s", stringPlayerInput);
                /* 
                    check if string is correct
                */
                if (strcmp(stringPlayerInput, "Fizz") != 0) {
                    playing = false;
                    printf("Oops, that the wrong answer! GAME OVER!\n");
                }
            } else if (counter % 7 == 0) {
                /*
                    input string
                */
                scanf("%s", stringPlayerInput);
                /* 
                    check if string is correct
                */
                if (strcmp(stringPlayerInput, "Buzz") != 0) {
                    playing = false;
                    printf("Oops, that the wrong answer! GAME OVER!\n");
                }
            } else {
                /*
                    input int
                */
                scanf("%i", &intPlayerInput);  
                /* 
                    check if int is correct
                */
                if (intPlayerInput != counter) {
                    playing = false;
                    printf("Oops, that the wrong number! GAME OVER!\n");
                }  
            }
        }

        /*
            change active player turn
        */
        if (playerTurn == 0) {
            playerTurn = 1;
        } else {
            playerTurn = 0;
        }
        
        counter = counter + 1;
    }
}