import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'quickSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def quickSort(arr: Array[Int]): Unit = {
    // Write your code here
    val p = arr(0)
    val left = arr.filter(x => x < p)
    val right = arr.filter(x => x > p)

    if (left.length < 2) {
      println(s"$left $p")
    } else {
      quickSort(left)
    }

    if (right.length < 2) {
      println(s"$right $p")
    } else {
      quickSort(right)
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    Result.quickSort(arr)
  }
}
