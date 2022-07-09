(*2.naloga*)

type 'a kv_pair = (string*'a);;
type 'a kv_array = ('a kv_pair) array;;

let my_arr = Array.make 10 ("",0);;

let kv_add arr el = 
  let add arr el =
    let con = ref true
    and count = ref 0
    in
    let isEmpty el = match el with
      | ("", _) -> true
      | _ -> false
    in
    while !con do
      if (isEmpty arr.(!count)) then (con := false; arr.(!count) <- el) else incr count
    done;
  in
  let getVal el = match el with
    | (k,_) -> String.length k 
  in
  let sort el1 el2 =
    let num = ref 0
    in
    if (getVal el1 > getVal el2) then num := 1;
    if (getVal el1 < getVal el2) then num := -1; 
    !num
  in 
  add arr el;
  Array.sort sort arr; 
;;
  
kv_add my_arr ("bla", 3);;
kv_add my_arr ("bl43a", 3);;

(*3.naloga*)

