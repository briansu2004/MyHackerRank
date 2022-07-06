import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'breakingRecords' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY scores as parameter.
   */

  def breakingRecords(scores: Array[Int]): Array[Int] = {
    // Write your code here
    var max, min = scores(0)
    var hiCnt, loCnt = 0

    for (i <- 1 until scores.length) {
      if (scores(i) > max) {
        hiCnt += 1
        max = scores(i)
      } else if (scores(i) < min) {
        loCnt += 1
        min = scores(i)
      }
    }

    Array(hiCnt, loCnt)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val scores = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.breakingRecords(scores)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
