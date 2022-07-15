import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'insertionSort2' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  def insertionSort2(n: Int, arr: Array[Int]): Unit = {
    // Write your code here
    val ar = arr.clone()
    for (i <- 1 until n) {
      val m = arr(i)
      if (m < arr(i - 1)) {
        var idx = i - 1
        var found = false
        while (!found && idx > 0) {
          if (m < arr(idx - 1)) {
            idx -= 1
          } else {
            found = true
          }
        }
        if (!found) {
          idx = 0
        }
        for (j <- i until idx by -1) {
          arr(j) = arr(j - 1)
        }
        arr(idx) = m
      }
      println(arr.mkString(" "))
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    Result.insertionSort2(n, arr)
  }
}
