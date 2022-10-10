(* This is an OCaml editor.
   Enter your program here and send it to the toplevel using the "Eval code"
   button or [Ctrl-e]. *)

class oseba (name : string) (surname : string) (idInput : int) =
  object
    val mutable id = idInput
    val mutable ime = name
    val mutable priimek = surname
    method predstavi = 
      Printf.sprintf "My name is %s %s and my ID is: %d" ime priimek idInput
  end;;
    
let robi = new oseba "Robert" "Gavranovic" 89211177;;
robi#predstavi;;




class ucitelj (name : string) (surname : string) (idInput : int) (wage : int) =
  object
    inherit oseba name surname idInput
    val placa = wage
    method predstavi =
      Printf.sprintf "My name is %s %s and my ID is: %d. I am a professor at FAMNIT university and my wage is %d€" ime priimek idInput wage
  end;;
    
let kljun = new ucitelj "Matjaz" "Kljun" 88888 9999;;
print_endline (kljun#predstavi);;




class student (name : string) (surname : string) (idInput : int) (nadrejen : string) =
  object
    inherit oseba name surname idInput
    val mentor = nadrejen
    method predstavi = 
      Printf.sprintf "My name is %s %s and my ID is: %d. I am a student at FAMNIT university and my mentor is %s" ime priimek idInput nadrejen
  end;;
    
let lovro = new student "Lovro" "Justin" 777777 "Robi";;
print_endline (lovro#predstavi);;




class asistent (name : string) (surname : string) (idInput : int) (wage : int) (nadrejen : string) = 
  object
    inherit ucitelj name surname idInput wage as ucitelj
    inherit student name surname idInput nadrejen as student
    method predstavi =
      Printf.sprintf "My name is %s %s and my ID is: %d. I am an asistant at FAMNIT university. My wage is %d€ and my mentor is %s." ime priimek idInput wage mentor
    method predstavi_vse = 
      print_endline (student#predstavi);
      print_endline (ucitelj#predstavi);
  end;;
    
let matjaz = new asistent "Matjaz" "Krnc" 666666 9999 "Kljun";; 
print_endline (matjaz#predstavi);;
matjaz#predstavi_vse;;