import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'libraryFine' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER d1
   *  2. INTEGER m1
   *  3. INTEGER y1
   *  4. INTEGER d2
   *  5. INTEGER m2
   *  6. INTEGER y2
   */

  def libraryFine(d1: Int, m1: Int, y1: Int, d2: Int, m2: Int, y2: Int): Int = {
    // Write your code here
    if (y2 * 1000000 + m2 * 1000 + d2 >= y1 * 1000000 + m1 * 1000 + d1) {
      0
    } else if (y2 < y1) {
      10000
    } else if (m2 < m1) {
      500 * (m1 - m2)
    } else {
      15 * (d1 - d2)
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val d1 = firstMultipleInput(0).toInt

    val m1 = firstMultipleInput(1).toInt

    val y1 = firstMultipleInput(2).toInt

    val secondMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val d2 = secondMultipleInput(0).toInt

    val m2 = secondMultipleInput(1).toInt

    val y2 = secondMultipleInput(2).toInt

    val result = Result.libraryFine(d1, m1, y1, d2, m2, y2)

    printWriter.println(result)

    printWriter.close()
  }
}
