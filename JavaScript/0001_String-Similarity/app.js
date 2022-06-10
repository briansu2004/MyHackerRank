// 'use strict';

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

/*
 * Complete the 'stringSimilarity' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts STRING s as parameter.
 */

function getZarr(str, strLength, zArray) {
  let left = 0;
  let right = 0;
  let k = 0;

  // [left, right] make a window which matches
  // with prefix of s
  // left = right = 0;
  for (let index = 1; index < strLength; index += 1) {
    // if index>right nothing matches so
    // we will calculate.
    // zArray[index] using naive way.
    if (index > right) {
      left = right = index;

      // right-left = 0 in starting, so it will start
      // checking from 0'th index. For example,
      // for "ababab" and index = 1, the value of right
      // remains 0 and zArray[index] becomes 0. For string
      // "aaaaaa" and index = 1, zArray[index] and right become 5
      while (right < strLength && str[right - left] === str[right]) {
        right += 1;
      }

      zArray[index] = right - left;
      right -= 1;
    } else {
      // k = index-left so k corresponds
      // to number which
      // matches in [left, right] interval.
      k = index - left;

      // if zArray[k] is less than
      // remaining interval
      // then zArray[index] will be equal to zArray[k].
      // For example, str = "ababab",
      // index = 3, right = 5
      // and left = 2
      if (zArray[k] < right - index + 1) {
        zArray[index] = zArray[k];
        // For example str = "aaaaaa"
        // and index = 2, right is 5,
        // left is 0
      } else {
        // else start from right and
        // check manually
        left = index;

        while (right < strLength && str[right - left] === str[right]) {
          right += 1;
        }

        zArray[index] = right - left;
        right -= 1;
      }
    }
  }
}

function stringSimilarity(s) {
  let zArray = new Array(s.length);
  // console.log(zArray);

  // Compute the zArray-array for the given string
  getZarr(s, s.length, zArray);

  let total = s.length;

  // Summation of the zArray-values
  for (let index = 1; index < s.length; index += 1) {
    total += zArray[index];
  }

  return total;
}

function main() {
  //   const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

  //   const t = parseInt(readLine().trim(), 10);

  //   for (let tItr = 0; tItr < t; tItr++) {
  //     const s = readLine();

  //     const result = stringSimilarity(s);

  //     ws.write(result + '\n');
  //   }

  //   ws.end();

  const s = 'ababaa';
  console.log(`The string similarity of ${s} is ${stringSimilarity(s)}`);
}

main();
