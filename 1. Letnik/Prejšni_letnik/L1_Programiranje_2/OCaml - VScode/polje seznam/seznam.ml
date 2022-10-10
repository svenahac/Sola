(* seznam.ml *)
let rec sestej seznam =
    if (seznam = []) then 0
    else (List.hd seznam) + sestej (List.tl seznam);;

let rec vrni seznam n = match seznam with 
    | [] -> 0
    | _ when (n<=0) -> 0
    | g::r when (n=1) -> g
    | g::r -> vrni r (n-1);;

let rec obrni seznam = match seznam with
    | [] -> []
    | g::r -> (obrni r) @ [g];;

let rec primerjaj s1 s2 = match s1 with
    | [] when (s2 = []) -> true
    | [] -> false
    | _ when (s2 = []) -> false
    | g::r -> primerjaj r (List.tl s2);;

let je_palindrom seznam =
 let rec vrni seznam n = match seznam with 
    | [] -> 0
    | _ when (n<=0) -> 0
    | g::r when (n=1) -> g
    | g::r -> vrni r (n-1) in
    let dolzina = List.length seznam in
    let rec primerjaj i j = match i with
        | _ when (i = j) -> true
        | _ when ((vrni seznam i) != (vrni seznam j)) -> false
        | _ -> primerjaj (i+1) (j-1)
        in
        primerjaj 1 dolzina;;
