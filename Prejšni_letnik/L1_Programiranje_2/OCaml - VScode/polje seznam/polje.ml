(* polje.ml *)
let zdruzi_polji2 p1 p2 =
    let p3 = Array.make (Array.length p1 + Array.length p2) p1.(0) in
    for i=0 to ((Array.length p1)-1) do p3.(i) <- p1.(i) done;
    for i=0 to ((Array.length p2)-1) do p3.(i+Array.length p1) <- p2.(i) done;
    p3;;

let naredi_polje_do n =
    let p = Array.make n 1 in
    let rec vpisi polje i = match n with
    | _ when (i = (n-1)) -> polje.(i) <- (i+1)
    | _ -> polje.(i) <- (i+1); vpisi polje (i+1) in
    vpisi p 0; p;;

let naredi_polje n m =
        let p = Array.make (m-n+1) 1 in
        for i=0 to (m-n) do p.(i) <- (i+n) done; p;;

let v_polje seznam =
    let rec velikost s = match s with
    | [] -> 0
    | g::r -> 1 + velikost r in
    let polje = Array.make (velikost seznam) (List.hd seznam) in
    let rec vpisi sez i = match sez with
        | [] -> polje
        | g::r -> polje.(i) <- g; vpisi r (i+1) in
        vpisi seznam 0;;

let naredi_matriko n m element =
    let stolpec = Array.make n element in
    let matrika = Array.make m stolpec in
    matrika;;
