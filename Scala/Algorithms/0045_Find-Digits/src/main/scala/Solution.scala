import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'findDigits' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  def findDigits(n: Int): Int = {
    // Write your code here
    n.toString.toCharArray.filter(x => x.asDigit > 0 && n % x.asDigit == 0).length
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = StdIn.readLine.trim.toInt

      val result = Result.findDigits(n)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
