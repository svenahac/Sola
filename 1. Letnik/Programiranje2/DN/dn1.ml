(*
Sven Ahac
RIN 1
89211304
Asistent: Krnc
*)
(*1. Naloga*)
let oddfirst s =
  let rec odd sez = match sez with
    | [] -> []
    | g::r -> if g mod 2 != 0 then g :: odd r else odd r
  in
  let rec even sez = match sez with
    | [] -> []
    | g::r -> if g mod 2 = 0 then g :: even r else even r
  in odd s @ even s ;; 

oddfirst [4;2;7;3;1;0;9;3;6;-1;0;3];;

(*3. Naloga*)
let summax2 sez =
  let urejen = List.sort compare sez
  in
  let dolzina = List.length sez
  in
  (List.nth urejen (dolzina-1) ) + (List.nth urejen (dolzina -2)) ;;

summax2 [1;4;6;2;7;8;3;10;4;-1];;

(*4. Naloga*)
let rec subset sez1 sez2 = match sez2 with
| [] -> []
| g::r -> 
  if 
    g < List.length sez1 && g >= 0 
  then
    List.nth sez1 g :: subset sez1 r
  else
    subset sez1 r;;

subset ["a";"b";"c";"d";"e";"f";"g"] [4;2;5;1];;
subset [10;20;30;40;50;60] [-10;1;3;2;0;100; -2];;
subset [1.2;4.5] [-10;13];;