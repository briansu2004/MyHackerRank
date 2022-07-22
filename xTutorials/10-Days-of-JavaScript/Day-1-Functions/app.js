'use strict';

/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */

const cache = [0, 1, 2, 6];

function factorial(n) {
  if (cache[n]) {
    return cache[n];
  }

  cache[n] = n * factorial(n - 1);
  return BigInt(n * factorial(n - 1)).toString();
}

function main() {
  const n = 100;

  //console.log(BigInt(factorial(n)).toString());
  console.log(factorial(n));
}

main();
