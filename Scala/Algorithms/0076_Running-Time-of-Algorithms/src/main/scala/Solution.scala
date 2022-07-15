import java.io.PrintWriter
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

  def runningTime(arr: Array[Int]): Int = {
    // Write your code here
    var total = 0
    val ar = arr.clone()
    for (i <- 1 until arr.length) {
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
          total += 1
        }
        arr(idx) = m
      }
      //println(arr.mkString(" "))
    }

    total
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.runningTime(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
