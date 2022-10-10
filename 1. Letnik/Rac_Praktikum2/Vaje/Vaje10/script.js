function printNum(num) {
  let result = 0;
  let squares = document.getElementsByClassName("square");
  for (let i = 0; i < squares.length; i++) {
    if (squares[i].classList.contains("clicked")) {
      result += parseInt(squares[i].innerHTML);
    }
  }

  let output = (document.getElementById("output").innerHTML = result);
}

function clicked(num) {
  let el = document.getElementById("sq" + num);
  if (el.classList.contains("clicked")) {
    el.classList.remove("clicked");
  } else {
    el.classList.add("clicked");
  }
}

let value = 128;

addSquare();
addSquare();
addSquare();
addSquare();
addSquare();
addSquare();
addSquare();
addSquare();

addQuestion();
addResult();

function addSquare() {
  let newSquare = document.createElement("div");
  newSquare.className = "square";
  newSquare.id = "sq" + value;
  newSquare.innerHTML = value;
  let current = value;
  newSquare.addEventListener("click", function () {
    clicked(current);
    printNum(current);
  });
  value /= 2;
  document.getElementById("squares").appendChild(newSquare);
}

function addQuestion() {
  let qmark = document.createElement("div");
  qmark.className = "test";
  qmark.innerHTML = "=";
  document.getElementById("squares").appendChild(qmark);
}

function addResult() {
  let result = document.createElement("div");
  result.className = "test";
  result.id = "output";
  document.getElementById("squares").appendChild(result);
}
