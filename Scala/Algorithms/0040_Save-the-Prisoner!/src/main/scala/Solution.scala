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
   * Complete the 'saveThePrisoner' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER m
   *  3. INTEGER s
   */

  def saveThePrisoner(n: Int, m: Int, s: Int): Int = {
    // Write your code here
    if ((m + s - 1) % n == 0) {
      n
    } else {
      (m + s - 1) % n
    }
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val n = firstMultipleInput(0).toInt

      val m = firstMultipleInput(1).toInt

      val s = firstMultipleInput(2).toInt

      val result = Result.saveThePrisoner(n, m, s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
