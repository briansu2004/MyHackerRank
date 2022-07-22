'use strict';

// The days of the week are: "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"

const WEEKDAYS = [
  'Sunday',
  'Monday',
  'Tuesday',
  'Wednesday',
  'Thursday',
  'Friday',
  'Saturday',
];

function getDayName(dateString) {
  let dayName;
  // Write your code here

  dayName = WEEKDAYS[new Date(dateString).getDay()];

  return dayName;
}

function main() {
  console.log(getDayName('10/11/2009'));
  console.log(getDayName('11/10/2010'));
}

main();
