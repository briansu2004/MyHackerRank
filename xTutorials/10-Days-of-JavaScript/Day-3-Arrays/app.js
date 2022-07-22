'use strict';

/**
 *   Return the second largest number in the array.
 *   @param {Number[]} nums - An array of numbers.
 *   @return {Number} The second largest number in the array.
 **/
function getSecondLargest(nums) {
  // Complete the function
  nums.sort(function (a, b) {
    return a - b;
  });
  const largest = nums[nums.length - 1];

  for (let i = nums.length - 2; i >= 0; i--) {
    if (nums[i] < largest) {
      return nums[i];
    }
  }

  return largest;
}

/*
5
2 3 6 6 5
=> 
5
*/
/*
10
10 9 9 8 8 11 8 0 9 1
=> 
10
*/
function main() {
  const n = 10; //+readLine();
  const nums = '10 9 9 8 8 11 8 0 9 1'.split(' ').map(Number);

  console.log(getSecondLargest(nums));
}

main();
