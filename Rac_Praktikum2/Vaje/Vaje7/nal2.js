function printNum(num) {
  let output = (document.getElementById("output").innerHTML = num);
}

let value = 0;

addSquare();
addSquare();
addSquare();

function addSquare() {
  let newSquare = document.createElement("div");
  value++;
  newSquare.className = "square";
  newSquare.innerHTML = value;
  let current = value;
  newSquare.addEventListener("click", function () {
    printNum(current);
  });
  document.getElementById("squares").appendChild(newSquare);
}
