class hisa p1 p2 p3 p4 p5 p6 =
  object 
    val mutable barva = (p1:string)
    val mutable st_oken = (p2:int)
    val mutable st_vrat = (p3:int)
    val st_etaz = p4
    val visina_etaze = 2.55
    val mutable st_sob = p5
    val velikost_sobe = p6

    method get_barva = barva
    method get_st_oken = st_oken
    method visina = float_of_int(st_etaz)*.visina_etaze
    method kvadratura = st_sob*velikost_sobe

  end;;

class vikend okna sobe velikost_sobe=
  object (self)
  inherit hisa "rjava" okna 1 1 sobe velikost_sobe as fotr
  method je_velik = self#kvadratura> 80
  method visina_vikenda = fotr#visina -. 0.5
  end;;

let macesen1 = new vikend 5 2 7;;
macesen1#je_velik;;
macesen1#get_barva;;

class virtual lik barva stranice = 
  object
    val barva = (barva:string)
    val st_stranic = (stranice:int)
    method virtual ploscina : int
    method virtual obseg : int
  end;;


class kvadrat barva a=
  object
  inherit lik barva 4
  method ploscina = a*a
  method obseg = 4*a
  end;;

let kvadrat1 = new kvadrat "bela" 10;;

