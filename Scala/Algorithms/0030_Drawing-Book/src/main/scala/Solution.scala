import java.io._
import java.math._
import java.util._
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'pageCount' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER p
   */

  def pageCount(n: Int, p: Int): Int = {
    // Write your code here
    val n1 = ((p - 1) + (p - 1) % 2) / 2
    var n2 = n1
    if (n % 2 == 0) {
      n2 = ((n - p) + (n - p) % 2) / 2
    } else {
      n2 = ((n - p) - (n - p) % 2) / 2
    }
    min(n1, n2)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val p = StdIn.readLine.trim.toInt

    val result = Result.pageCount(n, p)

    printWriter.println(result)

    printWriter.close()
  }
}
