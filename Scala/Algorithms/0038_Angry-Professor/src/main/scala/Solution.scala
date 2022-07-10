import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'angryProfessor' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY a
   */

  def angryProfessor(k: Int, a: Array[Int]): String = {
    // Write your code here
    if (a.count(x => x <= 0) >= k) {
      "NO"
    } else {
      "YES"
    }
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val n = firstMultipleInput(0).toInt

      val k = firstMultipleInput(1).toInt

      val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      val result = Result.angryProfessor(k, a)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
