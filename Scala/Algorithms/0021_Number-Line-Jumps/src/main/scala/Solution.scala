import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'kangaroo' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER x1
   *  2. INTEGER v1
   *  3. INTEGER x2
   *  4. INTEGER v2
   */

  def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String = {
    // Write your code here
    if ((x2 - x1) * (v1 - v2) > 0 && (x2 - x1) % (v1 - v2) == 0) {
      "YES"
    } else {
      "NO"
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val x1 = firstMultipleInput(0).toInt

    val v1 = firstMultipleInput(1).toInt

    val x2 = firstMultipleInput(2).toInt

    val v2 = firstMultipleInput(3).toInt

    val result = Result.kangaroo(x1, v1, x2, v2)

    printWriter.println(result)

    printWriter.close()
  }
}
