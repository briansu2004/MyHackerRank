# MyHackerRank with Scala

My HackerRank with Scala

## [Scala] Quick fix to fit the local env

```scala
val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))
```

->

```scala
val printWriter = new PrintWriter(System.out)
```

## [Scale] Read from file

If the IDE is IJ, just changing the "Run/Debug config".

![1657199466620](image/README/IJ_config_stdin.png)

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

## [Scala] Breaks, breakable, break

```scala
        val loop = new Breaks
        loop.breakable {
            for (i <- 0 to len / 2) {
                if (obj.popCharacter() != obj.dequeueCharacter()) {
                    isPalindrome = false
                    loop.break
                }
            }
        }
```

## [Scala] Stack

Annotations

@deprecated

Deprecated

(Since version 2.12.0) Stack is an inelegant and potentially poorly-performing wrapper around List. Use a List assigned to a var instead.

Scala program for implement stack using linked list.

mutable.Stack -> mutable.MutableList

```scala
var l = scala.collection.mutable.MutableList(1,2,3)
l += 4 
```

## [Scala] Queue

In Scala, Queue is implemented as a pair of lists. One is used to insert the elements and second to contain deleted elements. Elements are added to the first list and removed from the second list. The two most basic operations of Queue are Enqueue and Dequeue.

Enqueue – Adding an element at the end of the queue.

Dequeue – Deleting an element from the beginning of the queue.

## [Scala] LCM and GCD

```scala
  def gcd(a: Array[Int]): Int = {
    var n = a(0)
    for (i <- 1 until a.length) {
      n = gcd(n, a(i))
    }
    n
  }

  def gcd(a: Int, b: Int): Int = {
    var c = a
    var d = b
    while (d > 0) {
      var t = d
      d = c % d
      c = t
    }
    c
  }

  def lcm(a: Int, b: Int): Int = {
    a * (b / gcd(a, b))
  }

  def lcm(a: Array[Int]): Int = {
    var n = a(0)
    for (i <- 1 until a.length) {
      n = lcm(n, a(i))
    }
    n
  }
```
