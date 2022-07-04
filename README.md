# MyHackerRank

My HackerRank

## [Scala] read from file

```scala
val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
```

->

```scala
val printWriter = new PrintWriter(System.out)
```

## [Scala] I use Array[mutable.Queue[Int]] to solve graph problems with Scala

```scala
import scala.collection.mutable

...

    val graph: Array[mutable.Queue[Int]] = Array.fill[mutable.Queue[Int]](n)(mutable.Queue[Int]())
    for (i <- astronaut.indices) {
      val x = astronaut(i)(0)
      val y = astronaut(i)(1)
      graph(x).enqueue(y)
      graph(y).enqueue(x)
    }

    val visited: Array[Boolean] = Array.fill[Boolean](n)(false)
```

## [Java] read from file

```java
try (InputStream inputStream = new FileInputStream("stdin.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));) {
    ...
  } catch (Exception ex) {
    System.out.println(ex.getMessage());
  }
}
```

## [Python] Convert the code from HackerRank website to local

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

## [Java] List<Integer> to int[]

```java
int[] cookies = arr.stream().mapToInt(Integer::intValue).toArray();
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
