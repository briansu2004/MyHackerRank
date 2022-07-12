import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'repeatedString' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. LONG_INTEGER n
   */

  def repeatedString(s: String, n: Long): Long = {
    // Write your code here
    //(s * n).toCharArray.count(c => c == 'a')
    val l = s.length
    var single = s.count(c => c == 'a').toLong
    if (n < l.toLong) {
      return s.substring(0, n.toInt).count(c => c == 'a').toLong
    }
    (n - n % l) / l * s.count(c => c == 'a').toLong + s.substring(0, (n % l).toInt).count(c => c == 'a').toLong
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val s = StdIn.readLine

    val n = StdIn.readLine.trim.toLong

    val result = Result.repeatedString(s, n)

    printWriter.println(result)

    printWriter.close()
  }
}
