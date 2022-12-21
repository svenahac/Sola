

## Izračun velikosti B+ indeksa

**1. predpostavke**

RID - id zapisa (kaže iz listov direktno na zapise)
PID - id strani (kaže iz višjih nivojev na strani)

```
|RID| = |PID| = 8B
```

```
|tabela.atribut| = velikost(B) tabele / št. atributov tabele
npr.
|Knjige.leto| = 320/8B = 40B
```

**2. računanje velikosti B+ indeksa**

Velikost podatkovnega vpisa in velikost indeksnega vpisa

```
|indeksni vpis| = valikost atributa + RID (v B) (navzdol)
|indeksni vpis| = 40B + 8B = 48B
```

```
|podatkovni vpis| = valikost atributa + PID (v B) (navzdol)
|podatkovni vpis| =  = 40B + 8B = 48B
```

Izračunamo število podatkovnih vpisov na stran (PVS) 

```
PVS = velikost strani (8k) / |podatkovni vpis| (navzdol)
```

```
IVS = velikost strani (8k) / |indeksni vpis| (navzdol)
```

Izračunamo število strani

```
število zapisov / PVS (navzgor)
število zapisov / IVS (navzgor)
število zapisov / IVS (navzgor)
število zapisov / IVS (navzgor)
število zapisov / IVS (navzgor)
...
```

 To ponaljamo dokler ne pridemo do 1

```
1000000 / PVS = 6025 strani
6025 / IVS = 37 strani
37 / IVS = 1 stran
```

Ko pridemo do 1, seštejemo vse rezultate -> dobimo velikost indeksa v straneh

```
velikost indeksa = 6025 + 37 + 1 = 6063 strani
```

Izračunamo velikost v MB

```
število strani * velikost strani
npr.
6063 * 8000B = 48,504MB
```

---

## Evalvacija poizvedb

**1. Narišemo drevo**

zunanja relacija (M) - na levi strani

notranja relacija (N) - na desni strani

**2. izračunamo cene pregledov (v straneh)**

*če imamo selekcijo definirano pod stikom*

* Poizvedba vsebuje selekcijo &rarr; izračunamo št. strani in velikost spremenljivke T

* Poizvedba ne vsebuje selekcije &rarr; ne računamo nič

* Imamo definiran drevesni indeks &rarr; namesto cene pregleda zapišemo velikost indeksa

* Imamo definiran razpršilni indeks &rarr; ...

* Ni definiranega indeksa &rarr; zapišemo samo ceno pregleda in velikost spremenljivk T

Izračunamo število zapisov relacije, nad katero je definirana selekcija -> velikost spremenljivk T1, T2

$T1: št.zapisov = zapisov/stran * št.strani$

* Podano je število različnih vrednosti za atribut in število tistih, ki ustrezajo pogoju &rarr; izračunamo, koliko zapisov pripada eni različni vrednosti (predpostavimo enakomerno porazdeljenost podatkov med vrednosti)
  
  $zapisov/različno\;vrednost = \frac{št.zapisov}{št.različnih\;vrednosti} $
  
  Izračunamo, koliko zapisov ustreza pogoju
  
  $ustreznih = zapisov/različno;vrednost * različnih\;ustreznih$
  
  Izračunamo ceno v straneh
  
  $T1 = \frac{ustreznih}{zapisov/stran}$

če delamo s selektivnostjo:

* nepovezan B+ indeks:

$$
T1 = (število\;strani + (1+(10*\frac{število\;zapisov}{velikost\;strani})))*selektivnost
$$

+ povezan B+ indeks:
  
  $$
  T1 = \frac{število\;zapisov * selektivnost}{zapisov\;na\;stran}
  $$

$selektivnost = \frac{max - pogojna}{max - min}$

**3. Izračunamo ceno pri uporabo algoritma za stik**

M - zunanja relacija (strani)

N - notranja relacija (strani)

B - velikost vmesenga pomnilnika (strani)

* **Stik z vgenzdeno zanko**
  
  **po vrstah**
  
  $cena\;stika = M + st\;zapisovM*N$
  
  **po straneh**
  
  $cena\;stika = M+M*N$
  
  **po blokih**
  
  * če imamo v pomnilniku dovolj prostora za N+2 strani, pri čemer je N manjša relacija
  
      $cena\;stika = M+N$
  
  * če ni dovolj prostora
  
      $cena\;stika = M+N*(M/(B-2))$
  
  **z indekosm**
  
  * razpršilni indeks
    
    $cena\;stika=N+st\;zapisovN*(ujemajoče\;n-terice\;iz\;M+1.2)$
  
  * B+ drevo
    
    $cena\;stika=N+st\;zapisovN*(ujemajoče\;n-terice\;iz\;M+3)$

izračunamo skupno ceno

    $cena = pregled\;r1 + T1 + pregled\;r2 + T2 + cena\;stika$

* **Stik uredi-zlivaj** 
  
  Izračunamo ceno urejanja za vse spremenljivke T oz. relacije
  
  Uredi T2, uredi T1 oziroma uredi r1, uredi r2
  
  $uredi = 2*|M|*(1+log_{B-1}(\frac{|M|}{B}))$
  
  Zlijemo obe realciji
  
  $zlij(T1, T2) = strani\;T1 + strani\;T2$
  
  izračunamo ceno stika
  
  $cena\;stika = uredi\;T1 + uredi\;T2 + zjij(T1, T2)$
  
  Izračunamo skupno ceno
  
  $cena = pregled\;r1 + T1 + preged\;r2 + T2 + cena\;stika$

* **Razpršilni stik**
  
  $cena = 3*(M+n)$

**Stik z vgenzdeno zanko je vedno dražji kot stik uredi-zlivaj**

zakaj?

---

##### Linearni razpršilni indeks

level = število vrstic v trenutnem ciklu (brez dodatnih ustvarjenih strani)

N = stopnja števila vrstic(0 &rarr; 1 tabela | 1 &rarr; 2 tabeli | 2 &rarr; 4 tabele| ... )

**vstavljanje**

vstavljamo 18

$18\;mod\;(2^{level}*N)$

18 &rarr; 100<mark>10</mark>

<mark>10</mark> &rarr;vstavimo na mesto z indeksom 10

Če je stran, kamor vstavljamo polna in ni razcepljena, naredimo novo prelivno stran in vstavimo vanjo. Stran, na katero kaže next pregledamo in števila, ki ustrezajo binarnem zapisu nove strani, premaknemo na novo stran (spodaj).

Ko je next = N(level)-1...

---

##### SQL CREATE TABLE

```sql
CREATE TABLE filmi (
  fid int;
  naslov varchar(30) not null,
  leto_izdaje date not null,
  sid int not null default 1,
  PRIMARY KEY (fid),
  FOREIGN KEY (sid) REFERENCES studio
    ON DELETE SET DEFAULT ON UPDATE CASCADE
);
```

---

#### Odvisnosti

**Armstrongovi aksiomi**

refleksivnost: $y\subseteq x \implies x \to y$

razširitev: ${}x \to y \implies xz \to yz$

tranzitivnost: $x \to y, y \to z \implies x \to z$

**Tukaj je še nekaj...še neki aksiomi**

##### Normalne oblike

+ **1. normalna oblika**
  
  + ima določene funkcionalne odvisnosti
  
  + ima izbran primerni ključ
  
  + nima večvrednostnih atributov
* **2. normalna oblika**
  
  * je v 1. normalni obliki
  
  * nima parcialnih odvisnosti

* **3. normalna oblika**
  
  * je v 2. normalni obliki
  
  * nima tranzitivnih odvisnosti
