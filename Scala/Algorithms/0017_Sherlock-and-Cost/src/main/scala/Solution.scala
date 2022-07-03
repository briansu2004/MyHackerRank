import java.io._
import java.math._
import java.util._
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'cost' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY B as parameter.
   */

  def cost(B: Array[Int]): Int = {
    // Write your code here
    val n = B.length
    var hiSum, loSum = 0

    for (i <- 1 until n) {
      val loLo = 1 - 1
      val loHi = abs(B(i) - 1)
      val hiLo = abs(B(i - 1) - 1)
      val hiHi = abs(B(i - 1) - B(i))

      val newHiSum = max(loSum + loHi, hiSum + hiHi)
      val newLoSum = max(loSum + loLo, hiSum + hiLo)

      hiSum = newHiSum
      loSum = newLoSum
    }

    max(hiSum, loSum)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = StdIn.readLine.trim.toInt

      val B = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      val result = Result.cost(B)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
