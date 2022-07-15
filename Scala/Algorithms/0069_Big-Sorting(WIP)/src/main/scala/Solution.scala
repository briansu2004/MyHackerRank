import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'bigSorting' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY unsorted as parameter.
   */

  def bigSorting(unsorted: Array[String]): Array[String] = {
    // Write your code here
    unsorted.map { x => BigInt(x) }.sorted.map { x => x.toString }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val unsorted = Array.ofDim[String](n)

    for (i <- 0 until n) {
      val unsortedItem = StdIn.readLine
      unsorted(i) = unsortedItem
    }

    val result = Result.bigSorting(unsorted)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
