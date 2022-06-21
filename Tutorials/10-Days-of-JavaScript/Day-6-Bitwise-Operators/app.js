'use strict';

function getMaxLessThanK(n, k) {
  let res = 0;
  for (let i = 1; i < n; i++) {
    for (let j = i + 1; j <= n; j++) {
      if ((i & j) < k) {
        res = Math.max(res, i & j);
      }
    }
  }
  return res;
}

function main() {
  test(5, 2);
  test(8, 5);
  test(2, 2);
}

function test(n, k) {
  console.log(getMaxLessThanK(n, k));
}

main();
