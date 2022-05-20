import scala.io._

object Result {

  /*
   * Complete the 'miniMaxSum' function below.
   *
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def miniMaxSum(arr: Array[Int]): Unit = {
    // Write your code here
    var sum: Long = 0L
    for (i <- arr.indices) {
      sum = sum + arr(i)
    }

    println(s"${sum - arr.max} ${sum - arr.min}")
  }

}

object Solution {
  def main(args: Array[String]): Unit = {

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    Result.miniMaxSum(arr)
  }
}
