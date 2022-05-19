import scala.io._

object Result {

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def plusMinus(arr: Array[Int]): Unit = {
    // Write your code here
    var positive = 0
    var negative = 0

    for (i <- arr.indices) {
      if (arr(i) > 0) {
        positive = positive + 1
      } else if (arr(i) < 0) {
        negative = negative + 1
      }
    }

    println(f"${BigDecimal(positive) / BigDecimal(arr.length)}%.6f")
    println(f"${BigDecimal(negative) / BigDecimal(arr.length)}%.6f")
    println(f"${BigDecimal(arr.length - positive - negative) / BigDecimal(arr.length)}%.6f")
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    Result.plusMinus(arr)
  }
}
