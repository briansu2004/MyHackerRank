import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'separateNumbers' function below.
   *
   * The function accepts STRING s as parameter.
   */

  def isValid(n: Long, s: String): Boolean = {
    var m = n
    var str = m.toString

    while (str.length < s.length) {
      m += 1
      str += m.toString
    }

    if (str == s) {
      return true
    }
    false
  }

  def separateNumbers(s: String): String = {
    // Write your code here
    if (s.length < 2 || s(0) == '0') {
      return "NO"
    }

    for (i <- 1 to (s.length - s.length % 2) / 2) {
      val n = s.slice(0, i).toLong
      if (isValid(n, s)) {
        return "YES " + n.toString
      }
    }

    "NO"
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = StdIn.readLine

      println(Result.separateNumbers(s))
    }
  }
}
