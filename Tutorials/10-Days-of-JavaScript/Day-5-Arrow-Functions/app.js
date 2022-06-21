'use strict';

/*
 * Modify and return the array so that all even elements are doubled and all odd elements are tripled.
 *
 * Parameter(s):
 * nums: An array of numbers.
 */
// function modifyArray(nums) {
//   // // thought was based on the index
//   // nums.forEach((e, index) => {
//   //   nums[index] = e * (index % 2 ? 3 : 2);
//   // });
// }

/*
The forEach method allows you to execute a function by iterating through each element of an array. 
It’s important to note that the forEach method doesn’t return anything, 
and thus, if you try to get the return value of the forEach method, you will get undefined. 

The map method is very similar to the forEach method—it allows you to execute a function for each element of an array. 
But the difference is that the map method creates a new array using the return values of this function. 
map creates a new array by applying the callback function on each element of the source array. 
Since map doesn't change the source array, we can say that it’s an immutable method.
*/

const modifyArray = (nums) => nums.map((num) => (num % 2 ? num * 3 : num * 2));

function main() {
  const n = 5; // 9; // +(readLine());
  const a = [1, 2, 3, 4, 5]; //[14, 25, 36, 47, 58, 69, 70, 81, 92]; //readLine().split(' ').map(Number);

  console.log(modifyArray(a).toString().split(',').join(' '));
}

main();
