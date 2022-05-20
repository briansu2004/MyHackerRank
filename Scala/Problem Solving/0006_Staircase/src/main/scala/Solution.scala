import scala.io._

object Result {

  /*
   * Complete the 'staircase' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  def staircase(n: Int): Unit = {
    // Write your code here
    val sc = Array.fill(n) {
      ' '
    }
    for (i <- 0 until n) {
      sc(n - i - 1) = '#'
      sc.foreach(x => print(x))
      println()
    }
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    Result.staircase(n)
  }
}
