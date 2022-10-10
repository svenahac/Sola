let width = 10;
let height = 10;
let walls = 30;

let knightx = undefined;
let knighty = undefined;
let tiles = undefined;
let apples = 5;

function get_empty_place() {
  let y = 0;
  let x = 0;
  do {
    x = Math.floor(width * Math.random());
    y = Math.floor(width * Math.random());
  } while (tiles[y][x] !== "");
  return { col: x, row: y };
}

function init() {
  tiles = Array(height);
  for (let i = 0; i < height; i++) {
    tiles[i] = Array(width);
    for (let j = 0; j < width; j++) {
      tiles[i][j] = "";
    }
  }

  for (let i = 0; i < walls; i++) {
    let tile = get_empty_place();
    let x = tile.col;
    let y = tile.row;
    tiles[y][x] = "wall";
  }

  for (let i = 0; i < apples; i++) {
    let tile = get_empty_place();
    let x = tile.col;
    let y = tile.row;
    tiles[y][x] = "apple";
  }

  let tile = get_empty_place();
  knightx = tile.col;
  knighty = tile.row;
}

function drawTiles() {
  for (let row = 0; row < height; row++) {
    for (let col = 0; col < width; col++) {
      let cell = document.getElementById(`cell_${row}_${col}`);
      switch (tiles[row][col]) {
        case "wall":
          cell.innerHTML = `<img src="wall.png">`;
          break;
        case "apple":
          cell.innerHTML = `<img src="apple.png">`;
          break;
        default:
          cell.innerHTML = "";
      }
    }
  }
  let tile = document.getElementById(`cell_${knighty}_${knightx}`);
  tile.innerHTML = `<img src="knight.png">`;
}

function userAction(event) {
  let tox = knightx;
  let toy = knighty;
  switch (event.key) {
    case "ArrowUp":
      if (knighty > 0) toy--;
      break;
    case "ArrowDown":
      if (knighty < height - 1) toy++;
      break;
    case "ArrowLeft":
      if (knightx > 0) tox--;
      break;
    case "ArrowRight":
      if (knightx < width - 1) tox++;
      break;
    default:
      break;
  }
  if (tox == knightx && toy == knighty) return;
  if (tiles[toy][tox] === "wall") return;
  if (tiles[toy][tox] === "apple") tiles[toy][tox] = "";
  document.getElementById(`cell_${knighty}_${knightx}`).innerHTML = "";
  document.getElementById(
    `cell_${toy}_${tox}`
  ).innerHTML = `<img src="knight.png">`;
  knightx = tox;
  knighty = toy;
}

document.writeln(`<table class="playground">`);
for (let row = 0; row < width; row++) {
  document.writeln("<tr>");
  for (let col = 0; col < width; col++) {
    document.writeln(`<td class="cell" id="cell_${row}_${col}"></td>`);
  }
  document.writeln("</tr>");
}

init();
drawTiles();

document.addEventListener("keydown", userAction);
