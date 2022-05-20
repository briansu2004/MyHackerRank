import java.io._
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'hourglassSum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY arr as parameter.
   */

  def hourglassSum(arr: Array[Array[Int]]): Int = {
    // Write your code here
    val dim = 6
    var maxScore = scala.Int.MinValue

    for (i <- 1 until dim - 1) {
      for (j <- 1 until dim - 1) {
        // calculate hourglass score
        val score = arr(i - 1)(j - 1) + arr(i - 1)(j) + arr(i - 1)(j + 1) + arr(i)(j) + arr(i + 1)(j - 1) + arr(i +
          1)(j) + arr(i + 1)(j + 1)
        println(s"($i)($j): $score")

        // get max
        maxScore = max(maxScore, score)
      }
    }

    maxScore
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val arr = Array.ofDim[Int](6, 6)

    for (i <- 0 until 6) {
      arr(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.hourglassSum(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
