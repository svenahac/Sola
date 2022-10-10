(*Imperativno programiranje*)

let polje = [|1;4;42;14;2|];;

polje.(3);;

polje.(3)<-15;;

Array.make_matrix 3 2 0;;

(*Zanke*)

for i=0 to 4 do print_int i; print_string "\n"; done;;

for i=10 to 4 do print_int i; print_string "\n"; done;;

for i=10 downto 4 do print_int i; print_string "\n"; done;;

(*Tipi*)

type trikotnik = {a:int;b:int;c:int};;

let t1 = {a=4; c=5; b=3};;

t1.a

let vrni_hipotenuzo t = t.c;;

type trikotnik_m = {a:int;b:int;mutable h:int};;

let vrni_hipotenuzo t = t.h;;

let t2 = {a=4;h=5;b=3};;
t2.h <- 15;;

type oseba = {
  mutable ime:string;
  mutable priimek:string;
  mutable spol:char;
  mutable status:string;
  letnik:int
};;

let oseba1 = {spol='m'; ime="Denis"; priimek="Trump";letnik=1923;status="vdovec"};;
let oseba2 = {spol='z'; ime="Denisa"; priimek="Trump";letnik=1930;status="mrtva"};;

oseba1.status <- "mrtev";;

let poroka os1 os2 = os1.status <- "porocen";
                   os2.status <- "porocena";
                   os2.priimek <- os1.priimek;;

poroka oseba1 oseba2;;

type koordinata = float*float*string;;

let k1:koordinata = (12.58,133.8,"FAMNIT");

(*Tipi s konstruktorji*)

type barva = Modra | Rdeca | Zelena | Crna | Siva;;
type material = Usnje | Bombaz | Poliester | Svila | Lateks;;
type velikost = M | L | S | XL | XS;;

type obleka = barva*material*velikost;;

let majica:obleka = (Siva, Bombaz, M);;

type barva = RGB of int*int*int | CMYK of int*int*int*int | BW of int;;

RGB (255,255,0);;

[RGB (255,255,0); BW 15; CMYK (0,0,15,255); BW 0];;

type placilo = Gotovina of int | Kartica of string*string*int;;

let nakup1:placilo = (Gotovina (15));;
let nakup2:placilo = (Kartica ("Boris Johnson", "Visa", 400));;

let znesek nak = match nak with
| Gotovina x -> x
| Kartica (_,_,z) -> z;;

znesek nakup1;;
znesek nakup2;;

let nakupi = [Gotovina (15); Kartica ("Boris Johnson", "Visa", 400)];;

let rec skupni_znesek sez = match sez with
| [] -> 0
| g::r -> znesek g + skupni_znesek r;;

skupni_znesek nakupi;;