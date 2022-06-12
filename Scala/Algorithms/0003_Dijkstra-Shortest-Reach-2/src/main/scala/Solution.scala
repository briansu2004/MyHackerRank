import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.concurrent._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.reflect._
import scala.sys._
import scala.util.matching._

object Result {

  /*
   * Complete the 'shortestReach' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY edges
   *  3. INTEGER s
   */

  def shortestReach(n: Int, edges: Array[Array[Int]], s: Int): Array[Int] = {
    // Write your code here

    Array.ofDim[Int](0)
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val n = firstMultipleInput(0).toInt

      val m = firstMultipleInput(1).toInt

      val edges = Array.ofDim[Int](m, 3)

      for (i <- 0 until m) {
        edges(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      }

      val s = StdIn.readLine.trim.toInt

      val result = Result.shortestReach(n, edges, s)

      printWriter.println(result.mkString(" "))
    }

    printWriter.close()
  }
}
