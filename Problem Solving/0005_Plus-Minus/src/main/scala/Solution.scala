import scala.io._

object Result {

  /*
   * Complete the 'plusMinus' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def plusMinus(arr: Array[Int]) {
    // Write your code here
    var positive = 0
    var negative = 0

    arr.foreach(x => println(x))
    for (i <- arr.indices) {
      if (arr(i) > 0) {
        positive = positive + 1
      } else if (arr(i) < 0) {
        negative = negative + 1
      }
    }

    println(positive / arr.length)
    println(negative / arr.length)
    println((arr.length - positive - negative) / arr.length)
  }

}

object Solution {
  def main(args: Array[String]) {
    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    Result.plusMinus(arr)
  }
}
