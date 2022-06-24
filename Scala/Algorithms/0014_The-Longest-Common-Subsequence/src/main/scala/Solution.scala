/*
LCS (Longest Common Subsequence)
Theorem:
C[i,j] = match
  case x[i] = y[j] => c[i-1, j-1] + 1
  case x[i] != y[j] => max(c[i, j-1], c[i-1, j])
 */

import java.io._
import scala.collection.mutable
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'longestCommonSubsequence' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */

  def longestCommonSubsequence(a: Array[Int], b: Array[Int]): Array[Int] = {
    // Write your code here
    val n = a.length
    val m = b.length
    val dp = Array.ofDim[Int](n + 1, m + 1)

    for (i <- 0 to n) {
      for (j <- 0 to m) {
        if (i == 0 || j == 0) {
          dp(i)(j) = 0
        }
      }
    }

    for (i <- 1 to n) {
      for (j <- 1 to m) {
        if (a(i - 1) == b(j - 1)) {
          dp(i)(j) = dp(i - 1)(j - 1) + 1
        } else {
          dp(i)(j) = max(dp(i - 1)(j), dp(i)(j - 1))
        }
      }
    }

    var i = n
    var j = m
    val q = mutable.Queue[Int]()
    while (i > 0 && j > 0) {
      if (a(i - 1) == b(j - 1)) {
        q.enqueue(a(i - 1))
        i = i - 1
        j = j - 1
      } else {
        if (dp(i - 1)(j) > dp(i)(j - 1)) {
          i = i - 1
        } else {
          j = j - 1
        }
      }
    }

    q.toArray.reverse
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val m = firstMultipleInput(1).toInt

    val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val b = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.longestCommonSubsequence(a, b)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
