import java.io._
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'longestIncreasingSubsequence' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def longestIncreasingSubsequence(arr: Array[Int]): Int = {
    // Write your code here
    val tails = Array.fill[Int](arr.length)(0)
    var size = 0
    for (x <- arr) {
      var i = 0
      var j = size
      while (i != j) {
        val m = (i + j - (i + j) % 2) / 2
        if (tails(m) < x) {
          i = m + 1
        } else {
          j = m
        }
      }
      tails(i) = x
      size = max(i + 1, size)
    }
    size
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[Int](n)

    for (i <- 0 until n) {
      val arrItem = StdIn.readLine.trim.toInt
      arr(i) = arrItem
    }

    val result = Result.longestIncreasingSubsequence(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
