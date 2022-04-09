(* Selection sort *)

let rec find_min sez = match sez with
| [x] -> (x, [])
| g::r -> (let (a, preostanek) = find_min r in
            if g < a then (g,r) else (a, g::preostanek))
| [] -> (0,[]);;

find_min [4;54;98;8;7;-5];;

let rec find_min2 sez = match sez with
| [x] -> (x, [])
| g::r -> (match find_min2 r with
          | (a,_) when g < a -> (g,r)
          | (a,preostanek) -> (a,g::preostanek))
| [] -> (0,[]);;

find_min2 [4;54;98;8;7;-5];;

let rec selection_sort seznam = if seznam = [] then [] else
  match find_min seznam with
  | (m, []) -> [m]
  | (m,p) -> m :: selection_sort p;;

selection_sort [4;54;98;8;7;-5];;

(* Insertion sort *)

let rec insert1 seznam x = match seznam with
| [] -> [x]
| g::r -> if x < g then x:: seznam else g :: insert1 r x;;

insert1 [4;54;98;8;7;-5] 5;;

let rec insertion_sort2 unsorted sorted = match unsorted with
| [] -> sorted
| g::r -> insertion_sort2 r (insert1 sorted g);;

insertion_sort2 [4;54;98;8;7;-5] [];;

let insertion_sort s =
  let rec insert seznam x = match seznam with
    | [] -> [x]
    | g::r -> if x < g then x:: seznam else g :: insert r x
  in  
  let rec insertion_sort1 unsorted sorted = match unsorted with
    | [] -> sorted
    | g::r -> insertion_sort1 r (insert sorted g)
  in insertion_sort1 s [];;

insertion_sort [4;54;98;8;7;-5];; 

(* merge sort *)
let rec split sez = match sez with
| [] | [_] -> [],sez
| g1::g2::r -> let r1, r2 = split r in g1::r1, g2::r2;;

split [4;54;98;8;7;-5;0] ;;

let rec merge  sez1 sez2 = match sez1,sez2 with
| [], _ -> sez2
| _, [] -> sez1
| g1::r1, g2::r2 -> if g1 < g2 then g1 :: merge r1 sez2 
                    else g2 :: merge sez1 r2;;

merge [-5;88;789;1997] [-40;0;89;100;1000];;

let rec merge_sort sez = match sez with
| [] | [_] -> sez
| _ -> let (s1,s2) = split sez in 
       let s3 = merge_sort s1 and s4 = merge_sort s2 in merge s3 s4;;

merge_sort [4;54;98;8;7;-5;0];;

let pivot_split pivot seznam =
  (List.filter (fun x -> x < pivot) seznam, List.filter (fun x -> x >= pivot) seznam);;

pivot_split 50 [4;54;98;8;7;-5;0];;

let rec quick_sort sez = match sez with
| [] -> []
| g::r -> let (s1,s2) = pivot_split g r in (quick_sort s1) @ [g] @ (quick_sort s2);;


quick_sort [4;54;98;8;7;-5;0];;
