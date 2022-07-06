import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'birthday' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY s
   *  2. INTEGER d
   *  3. INTEGER m
   */

  def birthday(s: Array[Int], d: Int, m: Int): Int = {
    // Write your code here
    var cnt = 0

    for (i <- s.indices) {
      if (s.drop(i).take(m).sum == d) {
        cnt += 1
      }
    }

    cnt
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val s = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val d = firstMultipleInput(0).toInt

    val m = firstMultipleInput(1).toInt

    val result = Result.birthday(s, d, m)

    printWriter.println(result)

    printWriter.close()
  }
}
