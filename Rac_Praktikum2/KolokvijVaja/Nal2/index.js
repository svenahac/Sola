function generateSquares() {
  let table = document.getElementById("container");
  let count = 0;
  for (let i = 0; i < 10; i++) {
    let row = document.createElement("tr");
    for (let j = 0; j < 10; j++) {
      let current = count;
      let block = document.createElement("td");
      block.innerHTML = Math.floor(Math.random() * 99 + 1);
      block.style.backgroundColor = "yellow";
      block.onclick = function () {
        checkSquare(current);
      };
      block.id = `sq${count}`;
      count++;
      row.appendChild(block);
    }
    table.appendChild(row);
  }
}

function calculateSum() {
  let elements = document.querySelectorAll("td");
  let sumContainer = document.getElementById("sum");
  let sum = 0;
  for (let i = 0; i < elements.length; i++) {
    if (elements[i].style.backgroundColor === "gray") {
      sum += parseInt(elements[i].innerHTML);
    }
  }
  sumContainer.innerHTML = `Sum: ${sum}`;
}

function checkSquare(num) {
  let square = document.getElementById("sq" + num);
  if (square.style.backgroundColor === "yellow") {
    square.style.backgroundColor = "gray";
    calculateSum();
  } else if (square.style.backgroundColor === "gray") {
    square.style.backgroundColor = "yellow";
    calculateSum();
  }
}

generateSquares();
