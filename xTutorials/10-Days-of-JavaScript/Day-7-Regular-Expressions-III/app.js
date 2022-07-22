'use strict';
function regexVar() {
  /*
   * Declare a RegExp object variable named 're'
   * It must match ALL occurrences of numbers in a string.
   */
  const re = /[0-9]+/g;
  /*
   * Do not remove the return statement
   */
  return re;
}

function main() {
  const re = regexVar();

  const r = '102, 1948948 and 1.3 and 4.5'.match(re);

  for (const e of r) {
    console.log(e);
  }
}
