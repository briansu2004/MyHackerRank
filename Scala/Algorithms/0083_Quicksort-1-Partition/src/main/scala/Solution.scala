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

  def quickSort(arr: Array[Int]): Array[Int] = {
    // Write your code here
    arr.filter(x => x < arr(0)) ++ Array(arr(0)) ++ arr.filter(x => x > arr(0))
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.quickSort(arr)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
