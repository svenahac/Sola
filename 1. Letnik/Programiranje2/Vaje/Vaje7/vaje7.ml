class kosara (*morebitni parametni*) = 
  object
    (*metode, atributi*)
    val mutable jabolka = 0
    val mutable hruske = 0

    method get_jabolka = jabolka
    method get_hruske = hruske

    method set_jabolka a = jabolka <- a
    method set_hruske a = hruske <- a
  end;;

let k1 = new kosara;;

k1#get_hruske;;
k1#set_hruske 12;;

class ['a] hisa p1 p2 p3 p4 p5 p6 (zaklad:'a)=
  object (self)
    initializer if p2 < p5 then print_string "Opozorilo: premalo oken "
    val mutable barva = (p1:string)
    val mutable st_oken = (p2:int)
    val mutable st_vrat = (p3:int)
    val st_etaz = p4
    val visina_etaze = 2.55
    val mutable st_sob = p5
    val velikost_sobe = p6
    val zaklad = zaklad

    method get_barva = barva
    method get_st_oken = st_oken
    method visina = float_of_int(st_etaz)*.visina_etaze
    method kvadratura = st_sob*velikost_sobe
    method private set_st_oken a = st_oken <- a
    method private set_st_vrat a = st_vrat <- a
    method vrata_v_okno = 
      self#set_st_oken (st_oken + 1);
      self#set_st_vrat (st_vrat - 1)
    method okno_v_vrata = 
      self#set_st_oken (st_oken - 1);
      self#set_st_vrat (st_vrat + 1)
    method get_zaklad = zaklad
  end;;

let hisa1 = new hisa "oranzna" 12 9 3 11 12;;
let hisa2 = new hisa "crna" 9 7 4 16 7;;

hisa1#kvadratura;;

let boljsa h1 h2 =
  if h1#visina > h2#visina && h1#kvadratura > h2#kvadratura
  then print_string "Prva hisa je  boljša od druge"
  else if h2#visina > h1#visina && h2#kvadratura > h1#kvadratura
  then print_string "Prva hisa je slabsa od druge"
  else print_string "Hisi sta neprimerljivi";;

boljsa hisa1 hisa2;;

class prevozno_sredstvo hitrost razdalja =
  object
    val povprecna_hitrost = (hitrost:int)
    val razdalja_do_faksa = razdalja
    method cas_do_faksa = (string_of_float(60.*.(razdalja_do_faksa/.float_of_int(povprecna_hitrost)))) ^ " min"
  end;;

let noge = new prevozno_sredstvo 5 2.2;;

noge#cas_do_faksa;;