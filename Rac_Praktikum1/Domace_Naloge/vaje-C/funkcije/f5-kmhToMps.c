#include <stdio.h>
/*
    NAL: napiši program, ki uporabniku pretvori 
    km/h v m/s in obratno. Uporabnik smer
    pretvorbe izbere z vnosom št. 1 ali 2.
    Implementiraj funckiji (toKmh in toMps) 
    za pretvorbo ter za pretvorbo uporabljaj 
    konstante.
    1 m/s = 3.6 km/h
    
    IZPIS:
    Izberi smer pretvorbe:
    1) km/h -> m/s
    2) m/s -> km/h
    2
    Vpiši količino: 1
    km/h: 3.600000
*/

double toMps(double num);
double toKmh(double num);

/*
    inicializacija globalnih konstant
*/ 
const double COEFICIENT = 3.6;

int main() {
    printf("Izberi smer pretvorbe:\n1) km/h -> m/s\n2) m/s -> km/h\n");

    int directionInput;
    scanf("%i", &directionInput);

    double ammount;
    printf("Vpiši količino: ");
    scanf("%lf", &ammount);

    if (directionInput == 1) {
        printf("m/s: %lf\n", toMps(ammount));
    } else if(directionInput == 2) {
        printf("km/h: %lf\n", toKmh(ammount));
    } else {
        printf("Napacen vnos!\n");
    }
}

double toMps(double num) {
    return num / COEFICIENT;
}

double toKmh(double num) {
    return num * COEFICIENT;
}
