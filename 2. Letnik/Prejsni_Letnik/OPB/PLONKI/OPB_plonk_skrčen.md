## Izračun velikosti B+ indeksa

**1. predpostavke**

RID - id zapisa (kaže iz listov direktno na zapise)
PID - id strani (kaže iz višjih nivojev na strani)

|RID| = |PID| = 8B
|tabela.atribut| = velikost(B) tabele / št. atributov tabele



**2. računanje velikosti B+ indeksa**

|indeksni vpis| = valikost atributa + RID (v B) (navzdol)

|podatkovni vpis| = valikost atributa + PID (v B) (navzdol)

PVS = velikost strani (8k) / |podatkovni vpis| (navzdol)

IVS = velikost strani (8k) / |indeksni vpis| (navzdol)

število zapisov / PVS (navzgor)
število zapisov / IVS (navzgor)
število zapisov / IVS (navzgor)
...

 To ponaljamo dokler ne pridemo do 1 in seštejemo rezultate.

število strani * velikost strani



## Evalvacija poizvedb

**1. Narišemo drevo**

zunanja relacija (M) - na levi strani

notranja relacija (N) - na desni strani

**2. izračunamo cene pregledov (v straneh)**

če imamo podano število različnih zapisov

$T1: št.zapisov = zapisov/stran * št.strani$

$zapisov/različno\;vrednost = \frac{št.zapisov}{št.različnih\;vrednosti} $

$ustreznih = zapisov/različno;vrednost * različnih\;ustreznih$

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

* **Stik z vgenzdeno zanko**
  
  **po vrstah** &rarr; $cena\;stika = M + st\;zapisovM*N$
  
  **po straneh** &rarr; $cena\;stika = M+M*N$
  
  **po blokih**
  
  * dovolj prostora za N+2 strani (N manjša relacija) &rarr; $cena\;stika = M+N$
  
  * če ni dovolj prostora &rarr; $cena\;stika = M+N*(M/(B-2))$
  
  **z indekosm**
  
  * razpršilni indeks
    
    $cena\;stika=N+st\;zapisovN*(ujemajoče\;n-terice\;iz\;M+1.2)$
  
  * B+ drevo
    
    $cena\;stika=N+st\;zapisovN*(ujemajoče\;n-terice\;iz\;M+3)$

izračunamo skupno ceno

    $cena = pregled\;r1 + T1 + pregled\;r2 + T2 + cena\;stika$

* **Stik uredi-zlivaj** 
  
  Uredi T2, uredi T1 oziroma uredi r1, uredi r2
  
  $uredi = 2*|M|*(1+log_{B-1}(\frac{|M|}{B}))$
  
  $zlij(T1, T2) = strani\;T1 + strani\;T2$
  
  $cena\;stika = uredi\;T1 + uredi\;T2 + zjij(T1, T2)$
  
  $cena = pregled\;r1 + T1 + preged\;r2 + T2 + cena\;stika$

* **Razpršilni stik**
  
  $cena = 3*(M+n)$

**Stik z vgenzdeno zanko je vedno dražji kot stik uredi-zlivaj**

---

##### SQL CREATE TABLE

CREATE TABLE filmi (
 fid int;
 naslov varchar(30) not null,
 leto_izdaje date not null,
 sid int not null default 1,
 PRIMARY KEY (fid),
 FOREIGN KEY (sid) REFERENCES studio
 ON DELETE SET DEFAULT ON UPDATE CASCADE
);

---

#### Odvisnosti

**Armstrongovi aksiomi**

refleksivnost: $y\subseteq x \implies x \to y$

razširitev: ${}x \to y \implies xz \to yz$

tranzitivnost: $x \to y, y \to z \implies x \to z$



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
