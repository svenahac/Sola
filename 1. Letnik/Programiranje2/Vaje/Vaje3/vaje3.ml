let teden x =
        if x=1 then "ponedeljek" 
        else
            if x=2 then "torek" 
            else
                if x=3 then "sreda" 
                else
                    if x=4 then "cetrtek" 
                    else
                        if x=5 then "petek" 
                        else
                            if x=6 then "sobota" 
                            else
                            if x=7 then "nedelja" 
                            else "Napaka!";;


let teden x = match x with
| 1 -> "ponedeljek"
| 2 -> "torek"
| 3 -> "sreda"
| 4 -> "cetrtek"
| 5 -> "petek"
| 6 -> "sobota"
| 7 -> "nedelja"
| _ -> "napaka";;

let implikacija x = match x with
| (true, true) -> true
| (false, true) -> true
| (true, false) -> false
| (false, false) -> true;;

let implikacija x = match x with
| (true, false) -> false
| _ -> true;;

let jeSamoglasnik crka = match crka with
|'a' |'e'|'i'|'o'|'u' -> true
|'A' |'E'|'I'|'O'|'U' -> true
| _ -> false;; let teden x =
        if x=1 then "ponedeljek" 
        else
            if x=2 then "torek" 
            else
                if x=3 then "sreda" 
                else
                    if x=4 then "cetrtek" 
                    else
                        if x=5 then "petek" 
                        else
                            if x=6 then "sobota" 
                            else
                            if x=7 then "nedelja" 
                            else "Napaka!";;


let teden x = match x with
| 1 -> "ponedeljek"
| 2 -> "torek"
| 3 -> "sreda"
| 4 -> "cetrtek"
| 5 -> "petek"
| 6 -> "sobota"
| 7 -> "nedelja"
| _ -> "napaka";;

let implikacija x = match x with
| (true, true) -> true
| (false, true) -> true
| (true, false) -> false
| (false, false) -> true;;

let implikacija x = match x with
| (true, false) -> false
| _ -> true;;

let jeSamoglasnik crka = match crka with
|'a' |'e'|'i'|'o'|'u' -> true
|'A' |'E'|'I'|'O'|'U' -> true
| _ -> false;; 

jeSamoglasnik 'e';;
jeSamoglasnik 'p';;


let enakost = fun a b -> a=b;;

let enakost a b = match a with
| _ when a=b -> true
| _ -> false;;

enakost 5 5;;
enakost true false;;

let vsotaAliProdukt (a, b, kaj) = match kaj with
| "vsota" -> a+b
| "produkt" -> a*b
| _ -> 0;;

vsotaAliProdukt (22, 34, "vsota");;

let vsotaAliProdukt2 (a, b, kaj) = match (a, b, kaj) with
| (_,_,"vsota") -> a+b, (a, b, kaj)
| (_,_,"produkt") as param -> a*b, param
| _ as param -> 0, param;;

let rec dolzina seznam =
  if seznam=[] then 0 else
  1 + dolzina (List.tl seznam);;

let rec dolzina seznam = match seznam with
| [] -> 0
| g::r -> 1 + (dolzina r);;

dolzina[154;15;8;7;98];;

let drugiElement seznam = match seznam with
| [] | [_] -> 0
| prvi::drugi::rep -> drugi;;