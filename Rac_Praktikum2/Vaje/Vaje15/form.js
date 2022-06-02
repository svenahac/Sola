function potrdiObrazec() {
  let ime = document.getElementById("ime");
  if (ime.value.trim().split(" ").length < 2) {
    ime.style.backgroundColor = "lightcoral";
    return;
  } else {
    ime.style.backgroundColor = "";
  }

  let email = document.getElementById("email");
  if (email.value.trim().split("@")[1] != "student.upr.si") {
    email.style.backgroundColor = "lightcoral";
    return;
  } else {
    email.style.backgroundColor = "";
  }

  let obrazec = document.getElementById("obrazec");
  obrazec.submit();
}

let letniki = ["Pavziram", "1. Letnik", "2. Letnik", "3. Letnik", "Absolvent"];

let dodiplomskiProgrami = [
  "Matematika",
  "Računalništvo in informatika",
  "Bioinformatika",
  "Matematika v ekonomiji in financah",
  "Varstvena biologija",
  "Biopsihologija",
  "Sredozemsko kmetijstvo VS",
  "Sredozemsko kmetijstvo UN",
];

let magistrskiProgrami = [
  "Matematične znanosti",
  "Računalništvo in informatika",
  "Biopsihologija",
  "Varstvo narave",
  "Matematika s finančnim inženiringom",
  "Psihologija",
  "Trajnostno grajeno okolje",
  "Podatkovna znanost",
];

let doktorskiProgrami = [
  "Matematične znanosti",
  "Računalništvo in informatika",
  "Obnovljivi materiali za zdrava grajena okolja",
  "Suicidologija in duševno zdravje",
];

function zbrisiIzbire(select) {
  while (select.length > 0) {
    select.remove(0);
  }
}

function dodajLetnik(select, letniki, len) {
  for (let i = 0; i < len; i++) {
    let option = document.createElement("option");
    option.text = letniki[i];
    select.appendChild(option);
  }
}

function dodajIzbire(select, izbire) {
  for (let i = 0; i < izbire.length; i++) {
    let option = document.createElement("option");
    option.text = izbire[i];
    select.appendChild(option);
  }
}

function izbiraLetnika() {
  let stopnja = document.getElementById("stopnja");
  let program = document.getElementById("program");
  let letnik = document.getElementById("letnik");

  zbrisiIzbire(letnik);
  zbrisiIzbire(program);

  switch (stopnja.value) {
    case "Dodiplomski študij":
      dodajLetnik(letnik, letniki, 5);
      dodajIzbire(program, dodiplomskiProgrami);
      break;
    case "Magistrski študij":
      dodajLetnik(letnik, letniki, 3);
      dodajIzbire(program, magistrskiProgrami);
      break;
    case "Doktorski študij":
      dodajLetnik(letnik, letniki, 4);
      dodajIzbire(program, doktorskiProgrami);
      break;
    default:
      break;
  }
}

function ponastaviObrazec() {
  let program = document.getElementById("program");
  let letnik = document.getElementById("letnik");
  zbrisiIzbire(letnik);
  zbrisiIzbire(program);
}
