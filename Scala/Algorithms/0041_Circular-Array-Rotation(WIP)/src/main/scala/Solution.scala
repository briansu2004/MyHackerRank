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
   * Complete the 'circularArrayRotation' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER k
   *  3. INTEGER_ARRAY queries
   */

  def circularArrayRotation(a: Array[Int], k: Int, queries: Array[Int]): Array[Int] = {
    // Write your code here
    a.takeRight(k).concat(a.take(a.length - k))
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val k = firstMultipleInput(1).toInt

    val q = firstMultipleInput(2).toInt

    val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val queries = Array.ofDim[Int](q)

    for (i <- 0 until q) {
      val queriesItem = StdIn.readLine.trim.toInt
      queries(i) = queriesItem
    }

    val result = Result.circularArrayRotation(a, k, queries)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
