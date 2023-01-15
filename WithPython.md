# MyHackerRank with Python

My HackerRank with Python

## [Python] Quick fix to fit the local env

1. Create a local folder

2. Prepare stdin.txt

3. Grab the py code from HackerRank website (app.py)

4. Save a copy as app_fromfile.py

5. Change to `open('stdin.txt')` and replace all `input()` to `f.readline()`

Example:

```python
if __name__ == '__main__':
    with open('stdin.txt') as f:

        t = int(f.readline().strip())
```

## [Python] float['inf']

While performing mathematical operations ∞ is a very crucial concept.

float("inf") or float("INF") or float("Inf") or float("inF") or float("infinity") creates a float object holding infinity

float("-inf") or float("-INF") or float("-Inf") or float("-infinity") creates a float object holding negative infinity

float("NAN") or float("nan") or float("Nan") creates float holding not a number

## [Python] PE8 import

Refactor from

```python
from collections import *
from heapq import *
```

to soemthing like this -

```python
from collections import defaultdict
from heapq import heappop, heappush
```

## [Python] Tricky `f.readline().strip()`

stdin.txt

```bash
hackerhappy
hackerrank
9
```

```python
    with open('stdin.txt') as f:
        s = f.readline().strip()
```

With `.strip()` - 'hackerhappy'

Without `.strip()` - 'hackerhappy\n'

## [Python] Initialize an array

```python
arr=[]
arr = [0 for i in range(5)] 
print(arr)

arr_num = [0] * 5
print(arr_num)
```

## [Python] Initialize a 2-D array

```python
a = [[0 for x in range(columns)] for y in range(rows)]
```

## [Python] Add an element to a array

```python
my_input = ['Engineering', 'Medical'] 
my_input.append('Science') 
print(my_input) 
```
