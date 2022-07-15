import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'alternate' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def isValid(s: Array[Char]): Boolean = {
    for (i <- 0 to s.length - 2) {
      if (s(i) == s(i + 1)) {
        return false
      }
    }
    true
  }

  def alternate(s: String): Int = {
    // Write your code here
    val chars = s.toCharArray.distinct
    if (chars.length < 2) {
      return 0
    }
    var max = 0
    val it = chars.combinations(2)
    while (it.hasNext) {
      val cc = it.next().mkString("")
      val c: Array[Char] = s.toCharArray.filter(x => cc.contains(x))
      //println(s"$cc : ${c.mkString("")}")
      if (isValid(c)) {
        max = Math.max(max, c.length)
      }
    }

    max
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val l = StdIn.readLine.trim.toInt

    val s = StdIn.readLine

    val result = Result.alternate(s)

    printWriter.println(result)

    printWriter.close()
  }
}
