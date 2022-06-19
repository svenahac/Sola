(* Sven Ahac *)
(* RIN 1 *)
(* 89211304 *)
(* Krnc *)

(* 1. Naloga *)
(*a*)
type gender=M|F;;
type fTree = {n:string; s:string;g:gender;c: fTree array};;

let countfm drevo =
  let males = ref 0
  in
  let females = ref 0
  in
  let rec koliko drevo2 = 
    if (drevo2.g == M) then incr males else incr females;
    
    for i=0 to (Array.length drevo2.c -1 ) do
      koliko drevo2.c.(i);
    done;
  in
  koliko drevo;
  (!females, !males)
;;


let tree1={n="Edrice";s="Nkosi";g=F;c=[|{n="Waaiz";s="Dendera";g=M;c=[|{n="Bithiah";s="Ife";g=M;c=[|{n="Baahir";s="Nephthys";g=M;c=[||]};{n="Nane";s="Abayomi";g=F;c=[||]};|]};{n="Eshe";s="Uthman";g=F;c=[|{n="Bahiti";s="Amr";g=F;c=[||]};{n="Habibah";s="Djoser";g=F;c=[||]};|]};|]};{n="Nour";s="Sef";g=F;c=[|{n="Khepri";s="Hager";g=F;c=[|{n="Thema";s="Apep";g=F;c=[||]};{n="Femi";s="Eboney";g=M;c=[||]};{n="Saadah";s="Chione";g=M;c=[||]};|]};{n="Bastet";s="Nephi";g=F;c=[|{n="Nkosi";s="Zuberi";g=M;c=[||]};|]};|]};|]};;

countfm tree1;;

(*b*)

let childless drevo = 
  let arr = [||]
  in
  let rec retArr arr drevo = match drevo.c with 
  | [||] -> Array.append arr [|drevo|]
  | _ -> Array.fold_left retArr arr drevo.c
  in
  retArr arr drevo
;;

childless tree1;;

(* 2. Naloga *)

(*a*)

module Graph =
  struct
    type node = int
    type graph = (node*node list) list
    let order = List.length of type 
    let degree claw deg = (Array.of_list claw).(deg-1)
    let max_degree = prerr_int 2
    let min_degree = prerr_int 2
  end;;

let claw:Graph.graph = [1,[2;3;4];2,[1];3,[1];4,[1]] ;;

Graph.order claw;;

Graph.degree claw 1;;


(* 3. Naloga *)

(*a*)

class oseba ime priimek id =
  object
    val mutable ime = (ime:string)
    val mutable priimek= (priimek:string)
    val mutable id = (id:int)
    method predstavi = ("Ime mi je " ^ ime ^ " " ^ priimek ^ " moja indetifikacijska številka je: " ^ (string_of_int id) ^ ". ")
  end;;

let oseba1 = new oseba "Boris" "Pahor" 4;;
oseba1#predstavi;;

(*b*)

class ucitelj ime priimek id placa =
  object
  inherit oseba ime priimek id as oseba
  val placa = (placa:int)
  method predstavi = oseba#predstavi ^ "Zaslužim " ^ (string_of_int placa) ^ "€."
  end;;

let ucitelj1 = new ucitelj "Joze" "Novak" 5 2000;;
ucitelj1#predstavi;;

class student ime priimek id mentor =
  object
  inherit oseba ime priimek id as oseba
  val mentor = (mentor:string)
  method predstavi = oseba#predstavi ^ "Moj mentor je " ^ mentor ^ "."
  end;;

let student1 = new student "Jaka" "Von Strassberg" 2 "Joze";;
student1#predstavi;;

(*c*)

class asistent ime priimek id placa mentor =
  object
  inherit ucitelj ime priimek id placa as ucitelj
  inherit student ime priimek id mentor as student
  method predstavi = student#predstavi ^ "Zaslužim " ^ " in moj mentor je" ^ mentor ^ "."
  end;;

let asistent1 = new asistent "Tone" "Kladivo" 3 1700 "Joze";;

asistent1#predstavi;;