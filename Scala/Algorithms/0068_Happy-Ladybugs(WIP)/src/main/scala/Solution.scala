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
   * Complete the 'happyLadybugs' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING b as parameter.
   */

  def happyLadybugs(b: String): String = {
    // Write your code here


    "YES"
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val g = StdIn.readLine.trim.toInt

    for (gItr <- 1 to g) {
      val n = StdIn.readLine.trim.toInt

      val b = StdIn.readLine

      val result = Result.happyLadybugs(b)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
