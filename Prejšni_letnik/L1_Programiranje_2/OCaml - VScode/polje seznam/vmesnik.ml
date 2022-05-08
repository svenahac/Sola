(* vmesnik *)
module type SEZNAM = 
sig
    val sestej : int list -> int
    val obrni : 'a list -> 'a list
    val je_plindrom : int list -> bool
end;