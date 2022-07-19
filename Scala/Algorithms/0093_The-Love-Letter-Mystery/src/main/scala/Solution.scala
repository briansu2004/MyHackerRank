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
   * Complete the 'theLoveLetterMystery' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def theLoveLetterMystery(s: String): Int = {
    // Write your code here
    var cnt = 0
    for (i <- 0 until (s.length - s.length % 2) / 2) {
      cnt += Math.abs(s(i) - s(s.length - i - 1))
    }
    cnt
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = StdIn.readLine

      val result = Result.theLoveLetterMystery(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
