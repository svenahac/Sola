(* Sven Ahac *)
(* RIN 1 *)
(* 89211304 *)
(* Krnc *)

(* 1. Naloga *)

(*a*)
let matrix=[|
  [|false;true;false|];
  [|true;false;false|];
  [|false;false;true|];
  [|false;false;false|]
  |];;

let printmat matrix =
  let printArr myArr =
  for i = 0 to Array.length myArr -1 do
    match myArr.(i) with
    | true -> print_int 1
    | false -> print_int 0
  done
  in
  for j = 0 to Array.length matrix - 1 do
    printArr matrix.(j); print_newline ()
  done;;

printmat matrix;;

(*b*)

let onstepcontagion matrix =
  let counter = ref 0
  in
  let matrix3 =Array.make_matrix (Array.length matrix) (Array.length matrix.(0)) false
  in
  for i = 0 to Array.length matrix - 1 do
    let matrix2 = matrix.(i)
    in
    for j = 0 to Array.length matrix2 - 1 do
      if (i-1 >=0) then if (matrix.(i-1).(j) = true) then incr counter;
      if (i+1 < (Array.length matrix - 1)) then if (matrix.(i+1).(j) = true) then incr counter;
      if (j-1 >=0) then if (matrix.(i).(j-1) = true) then incr counter;
      if (j+1 <= (Array.length matrix.(0)) - 1) then if (matrix.(i).(j+1) = true) then incr counter;

      if matrix.(i).(j) = false then matrix3.(i).(j) <- false else matrix3.(i).(j) <- true;

      if !counter > 1 then matrix3.(i).(j) <- true;
      counter := 0;
    done;
  done;
  matrix3
;;

printmat (onstepcontagion matrix);;

(* 2. Naloga *)

(*a*)

type player= Orange | Red | Blue | White ;;
type piece= Knight of player| Town of player | City of player | Road of player | Wool of player |  Brick of player | Lumber of player | Grain of player | Ore of player;;

let getplayer piece = match piece with
  | Knight playerName -> playerName 
  | Town playerName -> playerName 
  | City playerName -> playerName 
  | Road playerName -> playerName 
  | Wool playerName -> playerName 
  | Brick playerName -> playerName 
  | Lumber playerName -> playerName 
  | Grain playerName -> playerName 
  | Ore playerName -> playerName;;


getplayer (Town Orange);;

let posessions=[|Ore Orange;Road Red;Ore Blue;Ore White;Lumber White;Ore Red;Knight Red;Road Orange;Lumber Red;Brick Red;City White;Lumber White;Wool Red;City White;Ore White;Brick White;Road Blue;Lumber Blue;Grain Orange;Wool Red;Road White;Knight White;Grain White;Wool Orange;City Blue;Ore Orange;Knight Orange;Brick White;Ore Red;Ore White;Road Orange;Knight Red;Lumber Orange;Wool Orange;City Orange;Wool Blue;Lumber White;City Red;Grain Red;Lumber Red;Ore White;Grain White;Brick Orange;Brick White;Road Blue;Grain Red;Ore White;City White;Road White;Knight Orange;Brick Red;Ore White;Lumber Orange;Ore Blue;Road Blue;Brick White;Brick Orange;Ore Orange;Ore Blue;Ore Orange;Ore Orange;Brick Orange;Brick White;Road Orange;Lumber White;Knight Red;Brick White;Brick Orange;Road Blue;Brick Orange;Lumber Blue;Road Blue;Ore Red;Grain Blue;Wool Red;Town Red;Ore Orange;Lumber White;Road Red;Road Blue;Town Blue;Wool Red;Lumber Blue;Wool Blue;Town Red;Grain Orange;Brick Blue;Knight Red;Wool White;Ore Orange;Ore Blue;Lumber White;Wool White;Brick Orange;Ore Blue;Grain Red;Wool Blue;Road Red;Ore Blue;Lumber Orange|];;

(*b*)

let filterbyplayer player myArr = 
  Array.of_list (List.filter (fun x -> player = getplayer x) (Array.to_list myArr))
;;

filterbyplayer Orange posessions;;

(*c*)

let countpoints player myArr =
  let points = ref 0;
  in
  let knights = ref 0;
  in
  let roads = ref 0;
  in
  let filterbyplayer player myArr = 
  Array.of_list (List.filter (fun x -> player = getplayer x) (Array.to_list myArr));
  in
  let myPiece piece = match piece with
  | Knight playerName -> "Knight" 
  | Town playerName -> "Town" 
  | City playerName -> "City" 
  | Road playerName -> "Road"
  | _ -> "";
  in
  let newArr = filterbyplayer player myArr;
  in
  for i = 0 to Array.length newArr - 1 do
    if ("Knight" = (myPiece newArr.(i))) then incr knights;
    if ("Town" = (myPiece newArr.(i))) then incr points;
    if ("City" = (myPiece newArr.(i))) then points := !points + 2;
    if ("Road" = (myPiece newArr.(i))) then incr roads;
  done;
  if (!roads > 4) then points := !points + 2;
  if (!knights > 2) then points := !points + 2;
  !points;
;;


countpoints Orange posessions;;
countpoints White posessions;;

(* 3. Naloga *)

(*a*)

type pipe= Plus | Minus | Block | Midbar;;

let pipeline1 =[|
 [| Minus ; Plus ; Minus ; Midbar ; Plus |];
 [| Midbar ; Plus ; Plus ; Minus ; Midbar |];
 [| Minus ; Plus ; Block ; Plus ; Block |];
 [| Plus ; Plus ; Minus ; Minus ; Block |];
 [| Minus ; Block ; Plus ; Midbar ; Block |];|];;

let boolArr =[|
[| true ; true ; true ; true ; true |];
[| true ; true ; true ; true ; true |];
[| true ; true ; true ; true ; true |];
[| true ; true ; true ; true ; true |];
[| true ; true ; true ; true ; true |];|];;

let print_pipeline mat1 mat2 =
  let matchArr myArr = match myArr with
    | Minus -> print_string "-"
    | Plus -> print_string "+"
    | Midbar -> print_string "|"
    | Block -> print_string "x"
  in
  for i = 0 to Array.length mat2 - 1 do
    for j = 0 to Array.length mat2 -1 do
      if (mat2.(i).(j) == true) then matchArr mat1.(i).(j) else print_string " ";
    done;
    print_string "\n";
  done;
;;

print_pipeline pipeline1 boolArr;;

(*b*)

let rotate_pipeline mat =
  let newMat = Array.make_matrix (Array.length mat) (Array.length mat) Plus;
  in
  for i = 0 to Array.length mat - 1 do
    for j = 0 to Array.length mat -1 do
        if (mat.(i).(j) = Plus) then newMat.(i).(j) <- Plus;
        if (mat.(i).(j) = Midbar) then newMat.(i).(j) <- Minus;
        if (mat.(i).(j) = Minus) then newMat.(i).(j) <- Midbar;
        if (mat.(i).(j) = Block) then newMat.(i).(j) <- Block;
      done;
  done; 
  newMat
;;

print_pipeline (rotate_pipeline pipeline1) boolArr;;

(*c*)

