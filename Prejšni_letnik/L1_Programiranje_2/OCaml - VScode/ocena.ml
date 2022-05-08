(* modul ocena *)
module Ocena = 
struct
    type ocena = {mutable vrednost : int; mutable predmet: string}
    let spremeniVrednost ocena vrednost_ocene _ ocena.vrednost <- vrednost_ocene
    let spremeniPredmet ocena ime_predmeta = ocena.predmet <- ime_predmeta
    let poglejOceno m = (m.vrednost, m.predmet)
    let ustvari = (vrednost = 0; predmet = "")
end;;

(* vmesnik za študenta *)
module type STUDENT = 
sig
    type ocena
    val poglejOceno : ocena -> int * string
end;;

(* vmesnik za profesorja *)
module type PROFESOR = 
sig
    type ocena
    val spremeniVrednost : ocena -> int -> unit
    val spremeniPredmet : ocena -> string -> unit
    val poglejOceno : ocena -> int * string
end;;


module Profesor = {Ocena:PROFESOR with type ocena=Ocena.ocena};;
module Student = {Ocena:STUDENT};;


let prog2 = Ocena.ustvari;;
Profesor.spremeniPredmet prog2 "Programiranje 2";;

Student.poglejOceno prog2;;