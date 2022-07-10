'use strict';

const fetch = require('fetch');

// const fs = require('fs');

// process.stdin.resume();
// process.stdin.setEncoding('utf-8');

// let inputString = '';
// let currentLine = 0;

// process.stdin.on('data', function (inputStdin) {
//   inputString += inputStdin;
// });

// process.stdin.on('end', function () {
//   inputString = inputString.split('\n');

//   main();
// });

// function readLine() {
//   return inputString[currentLine++];
// }

main();

/*
 * Complete the 'beadOrnaments' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts INTEGER_ARRAY b as parameter.
 */

function beadOrnaments(b) {
  // Write your code here
  let ans = b.reduce((ans, a) => ans * BigInt(a) ** (BigInt(a) - 1n), 1n);
  let sum = b.reduce((sum, a) => sum + BigInt(a), 0n);
  if (b.length - 2 >= 0) {
    ans *= sum ** BigInt(b.length - 2);
  } else {
    ans /= sum;
  }
  return ans % 1000000007n;
}

function main() {
  // // const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  // const t = parseInt(readLine().trim(), 10);

  // for (let tItr = 0; tItr < t; tItr++) {
  //   const bCount = parseInt(readLine().trim(), 10);

  //   const b = readLine()
  //     .replace(/\s+$/g, '')
  //     .split(' ')
  //     .map((bTemp) => parseInt(bTemp, 10));

  //   const result = beadOrnaments(b);

  //   console.log(result);
  //   //ws.write(result + '\n');
  // }

  // //ws.end();

  fetch('stdin.txt').then((response) => {
    const t = parseInt(response.text().trim(), 10);
    console.log(t);

    for (let tItr = 0; tItr < t; tItr++) {
      const bCount = parseInt(response.text().trim(), 10);

      const b = response
        .text()
        .replace(/\s+$/g, '')
        .split(' ')
        .map((bTemp) => parseInt(bTemp, 10));

      const result = beadOrnaments(b);

      console.log(result);
    }
  });
}
