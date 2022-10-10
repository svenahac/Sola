(* SEZNAMI *)
[12;23;43];;
1::[12;23;43];;
1::12::[23;43];;

let rec fib n = if n<3 then 1 else fib (n-1) + fib (n-2);;
fib 7;;

let rec fakulteta n = if n=0 then 1 else n*fakulteta (n-1);;
fakulteta 5;;

let rec seznam n = if n=1 then [1] else n::seznam (n-1);;
seznam 12;;

let rec sez n =
	if n=1 then [1]
	else n::sez (n-1);;

sez 12;;