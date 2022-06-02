let counter = 0;
let counterInterval = undefined;

function increaseCounter() {
  counter++;
  let number = document.getElementById("number");
  number.innerHTML = counter;
}

function startCounter() {
  if (counterInterval === undefined) {
    counterInterval = window.setInterval(increaseCounter, 1000);
  }
}

function stopCounter() {
  if (counterInterval !== undefined) {
    window.clearInterval(counterInterval);
  }
  counterInterval = undefined;
}

function clearCounter() {
  let runItAgain = false;
  if (counterInterval !== undefined) {
    stopCounter();
    startCounter();
  }
  counter = 0;
  number = document.getElementById("number").innerHTML = counter;
}

let x = 50;
let y = 50;
let vx = 50; // 5 px
let vy = 50; // 5 px
let dt = 1 / 50; //fps

function moveBall() {
  if (y > 130) vy *= -1;
  if (x > 180) vx *= -1;
  if (y <= 0) vy *= -1;
  if (x <= 0) vx *= -1;
  x += vx * dt;
  y += vy * dt;
  let ball = document.getElementById("ball");
  ball.style.left = x + "px";
  ball.style.top = y + "px";
}

let ballInterval = window.setInterval(moveBall, 1000 * dt);

function youWin() {
  window.alert("bazinga");
}
