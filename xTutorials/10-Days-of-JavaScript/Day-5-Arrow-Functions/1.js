const arr = ['a', 'b', 'c'];

arr.forEach((element, index) => {
  arr[index] = element + index;
});

console.log(arr);
