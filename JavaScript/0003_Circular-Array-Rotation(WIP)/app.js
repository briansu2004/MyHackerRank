'use strict';

const fetch = require('fetch');

main();
function circularArrayRotation(a, k, queries) {
  // Write your code here
  for (let i = 0; i < k; i++) {
    a.unshift(a.pop());
  }
  return queries.map((q) => a[q]);
}
function main() {
  fetch('stdin.txt').then((response) => {
    const firstMultipleInput = response
      .text()
      .trim()
      .replace(/\s+$/g, '')
      .split(' ');

    const n = parseInt(firstMultipleInput[0], 10);

    const k = parseInt(firstMultipleInput[1], 10);

    const q = parseInt(firstMultipleInput[2], 10);

    const a = response
      .text()
      .trim()
      .replace(/\s+$/g, '')
      .split(' ')
      .map((aTemp) => parseInt(aTemp, 10));

    let queries = [];

    for (let i = 0; i < q; i++) {
      const queriesItem = parseInt(readLine().trim(), 10);
      queries.push(queriesItem);
    }

    const result = circularArrayRotation(a, k, queries);

    console.log(result);
  });
}
