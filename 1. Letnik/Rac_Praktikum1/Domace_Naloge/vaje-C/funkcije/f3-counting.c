#include <stdio.h>
/*
    NAL: napiši program, ki štirikrat šteje do 20
    program naj kliče funkcijo "count", ki sprejme en argument, 
    ki predstavlja zgornjo mejo štetja (do kam preštejemo)
    
    IZPIS:
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20
*/

void countMultipleTimes(int timesToCount, int bound);
void count(int bound);

int main() {
    countMultipleTimes(4, 20);
}

void countMultipleTimes(int timesToCount, int bound) {
    for (int i = 0; i < timesToCount ; i++) {
        count(bound);
    }
}

void count(int bound) {
    for (int i = 1 ; i <= bound ; i++) {
        printf("%i ", i);
    }
    printf("\n");
}