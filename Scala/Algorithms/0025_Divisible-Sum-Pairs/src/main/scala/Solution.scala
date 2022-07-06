import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'divisibleSumPairs' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   *  3. INTEGER_ARRAY ar
   */

  def divisibleSumPairs(n: Int, k: Int, ar: Array[Int]): Int = {
    // Write your code here
    var cnt = 0

    for (i <- ar.indices) {
      for (j <- i + 1 until ar.length) {
        if ((ar(i) + ar(j)) % k == 0) {
          cnt += 1
        }
      }
    }

    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val k = firstMultipleInput(1).toInt

    val ar = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.divisibleSumPairs(n, k, ar)

    printWriter.println(result)

    printWriter.close()
  }
}
