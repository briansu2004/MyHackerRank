import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'serviceLane' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY cases
   */

  def serviceLane(width: Array[Int], cases: Array[Array[Int]]): Array[Int] = {
    // Write your code here
    var res: Array[Int] = Array.ofDim[Int](cases.length)

    for (i <- cases.indices) {
      res(i) = width.slice(cases(i)(0), cases(i)(1) + 1).min
    }

    res
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val t = firstMultipleInput(1).toInt

    val width = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val cases = Array.ofDim[Int](t, 2)

    for (i <- 0 until t) {
      cases(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.serviceLane(width, cases)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
