function preveriPodatke() {
  let imeInput = document.getElementById("ime");
  if (imeInput.value.split(" ").length < 2) {
    imeInput.style.backgroundColor = "rgba(255, 0, 0, 0.5)";
  } else {
    imeInput.style.backgroundColor = "white";
  }

  let mailInput = document.getElementById("mail");
  if (mailInput.value.trim().split("@")[1] != "student.upr.si") {
    mailInput.style.backgroundColor = "rgba(255, 0, 0, 0.5)";
  } else {
    mailInput.style.backgroundColor = "white";
  }

  document.getElementById("obrazec").submit();
}

const dodiplomskiProgrami = [
  "Matematika",
  "Računalništvo in informatika",
  "Bioinformatika",
  "Biopsihologija",
];

function dodajPrograme(select, programi) {
  for (let x in programi) {
    let option = document.createElement("option");
    option.text = programi[x];
    select.appendChild(option);
  }
}

function izbrisiPrograme(select) {
  while (select.length > 0) {
    select.remove(0);
  }
}

function izbiraPrograma() {
  let stopnjaSelect = document.getElementById("stopnja");
  let programSelect = document.getElementById("program");
  switch (stopnjaSelect.value) {
    case "Dodiplomski študij":
      izbrisiPrograme(programSelect);
      dodajPrograme(programSelect, dodiplomskiProgrami);
      break;
    case "Magisterki študij":
      break;
    case "Doktorski študij":
      break;
    default:
      izbrisiPrograme(programSelect);
  }
}
