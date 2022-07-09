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

module Graph :
   sig
    type node = int
    type graph = ( node * node list ) list
    val order : graph -> int
    val degree : graph -> node -> int
    val max_degree : graph -> int
    val min_degree : graph -> int

  end
=
  struct
    type node = int
    type graph = (node*node list) list
    let order (graf:graph) = (List.length graf)
    let degree (graf:graph) (deg:node) = match ((Array.of_list graf).(deg-1)) with
                                        | _, list -> (List.length list)
    let max_degree (graf:graph) = 
      let degree graf deg = match ((Array.of_list graf).(deg)) with
                                        | _, list -> (List.length list)
      in
      let max = ref (degree graf 0)
      in
      for i=0 to (List.length graf -1) do 
        if (!max <= (degree graf i)) then max:= (degree graf i)
      done;
      !max
    let min_degree (graf:graph) = 
      let degree graf deg = match ((Array.of_list graf).(deg)) with
                                        | _, list -> (List.length list)
      in
      let min = ref (degree graf 0)
      in
      for i=0 to (List.length graf -1) do 
        if (!min > (degree graf i)) then min:= (degree graf i)
      done;
      !min
  end

let claw:Graph.graph = [1,[2;3;4];2,[1];3,[1];4,[1]] ;;
let claw2:Graph.graph = [1,[2;4;3;4];2,[2;3;4];3,[12;3;4];4,[1;2]] ;;


Graph.order claw;;

Graph.degree claw 1;;

Graph.max_degree claw;;
Graph.min_degree claw;;


(* 3. Naloga *)

(*a*)

class oseba ime_ priimek_ id_ =
  object
    val mutable ime = (ime_:string)
    val mutable priimek= (priimek_:string)
    val mutable id = (id_:int)
    method predstavi = ("Ime mi je " ^ ime ^ " " ^ priimek ^ " moja indetifikacijska številka je: " ^ (string_of_int id) ^ ". ")
  end;;

let oseba1 = new oseba "Boris" "Pahor" 4;;
oseba1#predstavi;;

(*b*)

class ucitelj ime_ priimek_ id_ placa_ =
  object
  inherit oseba ime_ priimek_ id_ as oseba
  val placa = (placa_:int)
  method predstavi = oseba#predstavi ^ "Zaslužim " ^ (string_of_int placa) ^ "€."
  end;;

let ucitelj1 = new ucitelj "Joze" "Novak" 5 2000;;
ucitelj1#predstavi;;

class student ime_ priimek_ id_ mentor_ =
  object
  inherit oseba ime_ priimek_ id_ as oseba
  val mentor = (mentor_:string)
  method predstavi = oseba#predstavi ^ "Moj mentor je " ^ mentor ^ "."
  end;;

let student1 = new student "Jaka" "Von Strassberg" 2 "Joze";;
student1#predstavi;;

(*c*)

class asistent ime_ priimek_ id_ placa_ mentor_ =
  object(self)
  inherit ucitelj ime_ priimek_ id_ placa_ as ucitelj
  inherit student ime_ priimek_ id_ mentor_ as student
  method predstavi = ucitelj#predstavi ^" Moj mentor je " ^ mentor ^ "."
  method predstavi_vse =  print_endline(ucitelj#predstavi); print_endline(student#predstavi); print_endline(self#predstavi)
  end;;

let asistent1 = new asistent "Tone" "Kladivo" 3 1700 "Joze";;


asistent1#predstavi;;
asistent1#predstavi_vse;;


