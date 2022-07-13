import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'chocolateFeast' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER c
   *  3. INTEGER m
   */

  def chocolateFeast(n: Int, c: Int, m: Int): Int = {
    // Write your code here
    var cnt = 0

    // #1
    var wrapperCount = (n - n % c) / c
    cnt += wrapperCount

    // #2
    while (wrapperCount >= m) {
      val tradeWrapper = (wrapperCount - wrapperCount % m) / m
      cnt += tradeWrapper
      wrapperCount = wrapperCount % m + tradeWrapper
    }

    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val n = firstMultipleInput(0).toInt

      val c = firstMultipleInput(1).toInt

      val m = firstMultipleInput(2).toInt

      val result = Result.chocolateFeast(n, c, m)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
