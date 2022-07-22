import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'weightedMean' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY X
   *  2. INTEGER_ARRAY W
   */

  def weightedMean(X: Array[Int], W: Array[Int]): BigDecimal = {
    // Write your code here
    var score: BigDecimal = 0
    var total: BigDecimal = 0

    for (i <- X.indices) {
      score = score + X(i) * W(i)
      total = total + W(i)
    }

    score / total
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    val vals = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val weights = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val res = Result.weightedMean(vals, weights)

    println(f"$res%.1f")
  }
}
