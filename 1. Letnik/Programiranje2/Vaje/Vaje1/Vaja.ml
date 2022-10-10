print_string "Hello World\n";;

1;;

true;

true || false;;

4 + 78;;

(+);;

(<);;

let a = 12;;

let b = true;;

let rec zdruzi list1 list2 = match (list1, list2) with
| ([], []) -> []
| (a, []) -> a
| ([], b) -> b
| (a::b, c::d) ->
if(a < c) then a::(zdruzi b (c::d))
else if (c<a) then c::(zdruzi (a::b) d)
else a::(zdruzi b d);;

();;	

print_string;;

(* to je komentar

	se vedno
*)

true && false;;

not true;; 	
	
if true then false else true;;
	
if false then 2 else false;;

12 - -2

123.	

(+.);;

int_of_float 12.8
float_of_int 12

( ** );;

'c';;
int_of_char 'c';;

"to je niz"

string_of_int 2022;;

string_of_int (1+1);;

1<12;;



	
	
	