'use strict';

/*
 * Complete the vowelsAndConsonants function.
 * Print your output using 'console.log()'.
 */
function vowelsAndConsonants(s) {
  const ALL_VOWELS = ['a', 'e', 'i', 'o', 'u'];
  const vowels = [];
  const consonants = [];
  for (let c of s) {
    if (ALL_VOWELS.includes(c)) {
      vowels.push(c);
    } else {
      consonants.push(c);
    }
  }

  vowels.forEach((c) => console.log(c));
  consonants.forEach((c) => console.log(c));
}

function main() {
  const s = 'javascriptloops';

  vowelsAndConsonants(s);
}

main();
