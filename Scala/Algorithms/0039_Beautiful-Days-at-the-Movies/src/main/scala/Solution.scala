import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'beautifulDays' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER i
   *  2. INTEGER j
   *  3. INTEGER k
   */
//  def reverseInt(n: Int): Int = {
//    var res = n % 10
//    var i = (n - res) % 10
//    while (i > 9) {
//      res *= 10 + i % 10
//      i = (i - i % 10) / 10
//    }
//    res *= 10 + i
//    res
//  }

  def beautifulDays(i: Int, j: Int, k: Int): Int = {
    // Write your code here
    (i to j).count(n => Math.abs(n - n.toString.reverse.toInt) % k == 0)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val i = firstMultipleInput(0).toInt

    val j = firstMultipleInput(1).toInt

    val k = firstMultipleInput(2).toInt

    val result = Result.beautifulDays(i, j, k)

    printWriter.println(result)

    printWriter.close()
  }
}
