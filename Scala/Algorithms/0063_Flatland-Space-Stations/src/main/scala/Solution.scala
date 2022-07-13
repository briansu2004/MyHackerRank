import java.io._
import java.math._
import java.util._
import java.util.concurrent._

object Solution {

  // Complete the flatlandSpaceStations function below..
  def flatlandSpaceStations(n: Int, arr: Array[Int]): Int = {
    val c = arr.sorted
    var max = Math.max(c(0), n - c(c.length - 1) - 1)
    for (i <- 1 until c.length) {
      max = Math.max(max, ((c(i) - c(i - 1)) - (c(i) - c(i - 1)) % 2) / 2)
    }
    max
  }

  def flatlandSpaceStations1(n: Int, c: Array[Int]): Int = {
    var max = 0

    for (i <- 0 until n) {
      if (c.count(x => x == i) == 0) {
        var left = Int.MaxValue
        var right = Int.MaxValue
        // not a space
        if (c.count(x => x < i) > 0) {
          left = Math.min(left, i - c.filter(x => x < i).max)
        }
        if (c.count(x => x > i) > 0) {
          right = Math.min(right, c.filter(x => x > i).min - i)
        }
        max = Math.max(max, Math.min(left, right))
      }
    }

    max
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(System.out)

    val nm = stdin.readLine.split(" ")

    val n = nm(0).trim.toInt

    val m = nm(1).trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = flatlandSpaceStations(n, c)

    printWriter.println(result)

    printWriter.close()
  }
}
