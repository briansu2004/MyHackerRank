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
   * Complete the 'runningMedian' function below.
   *
   * The function is expected to return a DOUBLE_ARRAY.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  def runningMedian(a: Array[Int]): Array[Double] = {
    // Write your code here
    val n = a.length
    for (i <- a.indices) {

    }


    Array(0.0)
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val aCount = StdIn.readLine.trim.toInt

    val a = Array.ofDim[Int](aCount)

    for (i <- 0 until aCount) {
      val aItem = StdIn.readLine.trim.toInt
      a(i) = aItem
    }

    val result = Result.runningMedian(a)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
