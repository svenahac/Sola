function isPrime(number) {
  if (number == 1) return false;

  for (let k = 2; k <= Math.floor(number / 2); k++) {
    if (number % k == 0) return false;
  }
  return true;
}

function buildTable(width, height) {
  let n = 1;
  let table = document.getElementById("numbers");
  for (let i = 0; i < height; i++) {
    let row = table.insertRow(-1); // Nova vrstica na koncu tabele.
    for (let j = 0; j < width; j++) {
      let cell = row.insertCell(-1); // Nova celica na koncu vrstice.
      cell.innerHTML = n;
      if (isPrime(n)) cell.style.backgroundColor = "red";
      n++;
    }
  }
}

function clearTable() {
  let table = document.getElementById("numbers");
  //table.innerHTML = "";

  while (table.rows.length > 0) table.deleteRow(0);
}

function refreshTable() {
  clearTable();
  let width = document.getElementById("width").value;
  let height = document.getElementById("height").value;
  buildTable(width, height);
}
