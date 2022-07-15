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
   * Complete the 'superReducedString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def superReducedString(str: String): String = {
    // Write your code here
    var s = str
    var i = 0
    while (i < s.length - 1) {
      if (s(i) == s(i + 1)) {
        s = s.slice(0, i) + s.slice(i + 2, s.length)
        i = 0
      } else {
        i += 1
      }
    }

    if (s.length == 0) {
      s = "Empty String"
    }
    s
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val s = StdIn.readLine

    val result = Result.superReducedString(s)

    printWriter.println(result)

    printWriter.close()
  }
}
