(* map *)
let a = [1;2;3;4;6];;

List.map (fun x -> x+1) a;;

let rec map f sez = match sez with
| [] -> []
| hd::tl -> f hd :: map f tl;;

map (fun x -> x+1) a;;

(* fold right *)
(* f *)
(* a1,a2, ...., ak *)
(* b *)
(* f(a1,f(a2, f(a3, ..., f(ak,b)))) *)

List.fold_right (+) a 100;;

(+) 12 13;;

let rec fold_right f lst b = match lst with
| [] -> b
| hd::tl -> f hd (fold_right f tl b);;

fold_right (+) a 100;;

let rec fold_left f a lst = match lst with 
| [] -> a
| hd::tl -> f (fold_left f a tl) hd;;

fold_left (+) 100 a;;


(* List.filter *)

(* List.for_all *)

let pozitiven = function x -> x>0;;

pozitiven 12;;
pozitiven (-12);;

List.for_all pozitiven a;;
List.for_all pozitiven [1;2;3;4;-6];;

let rec for_all f sez = match sez with
| [] -> true
| g::r  when f g -> for_all f r
| _ -> false;;

for_all pozitiven a;;
for_all pozitiven [1;2;3;4;-6];;

(* vaje *)

let vecji = function (a,b) -> a > b;;
vecji (6,5);;

let rec urediPar (a,b) f =
  if f (a,b) then (a,b) else (b,a);;

urediPar (6,5) vecji;;
urediPar (5,6) vecji;;

