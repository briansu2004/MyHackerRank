'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');
let inputString: string = '';
let inputLines: string[] = [];
let currentLine: number = 0;
process.stdin.on('data', function (inputStdin: string): void {
  inputString += inputStdin;
});

process.stdin.on('end', function (): void {
  inputLines = inputString.split('\n');
  inputString = '';
  main();
});

function readLine(): string {
  return inputLines[currentLine++];
}

function main() {
  // Enter your code here

  let arr = inputLines.map(readLine);
  const map: { [key: string]: boolean } = {};
  arr.forEach((el, idx) => {
    if (el in map) {
      // do nothing and skip (don't print as it's a duplicate)
    } else if (idx !== 0) {
      // if el is not in map then add to map
      map[el] = true;
      // print the values of the array arr that is not index = 0 (because this is just the arr.length so skip it) and then print every value that is NOT in the map (not printing duplicates)
      console.log(el);
    }
  });
}
