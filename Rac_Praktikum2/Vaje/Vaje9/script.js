let emptyCellID = "cell9";

function squareDrag(event, number) {
  console.log(`Kvadrat ${number}`);
  event.dataTransfer.setData("text", number.toString());
}

function squareOver(event) {
  event.preventDefault();
  console.log("Premik čez celico");
}

function squareDrop(event, cellNum) {
  event.preventDefault();
  let squareNum = event.dataTransfer.getData("text");
  console.log(`Spustil sm številko ${squareNum} na celico št. ${cellNum}`);

  let draggedSquare = document.getElementById("square" + squareNum);
  let targetCell = document.getElementById("cell" + cellNum);

  if (targetCell.innerHTML.trim() === "") {
    emptyCellID = draggedSquare.parentNode.id;
    targetCell.appendChild(draggedSquare);
  }
}

function shuffle() {
  for (let i = 0; i < 100; i++) {
    let randSquareNum = Math.floor(Math.random() * 8) + 1;
    let randomSquare = document.getElementById("square" + randSquareNum);
    let sourceCellID = randomSquare.parentNode.id;
    let targetCell = document.getElementById(emptyCellID);
    targetCell.appendChild(randomSquare);
    emptyCellID = sourceCellID;
  }
}
