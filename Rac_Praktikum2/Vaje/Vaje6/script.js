for (let i = 0; i <= 255; i++) {
  document.write(`<div style="background-color: rgb(255, 255, ${255 - i});">`);
  document.write(i + "\n");
  document.write("</div>");
}
