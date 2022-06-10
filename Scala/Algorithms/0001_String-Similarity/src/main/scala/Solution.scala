import java.io._
import scala.io._
import scala.util.control.Breaks._

object Result {

  /*
   * Complete the 'stringSimilarity' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def stringSimilarity(s: String): Int = {
    // Write your code here
    var n = s.length
    for (i <- 1 until s.length) {
      val ns = s.slice(i, s.length)
      n = n + getStringSimilarity(s, ns)
    }
    n
  }

  def getStringSimilarity(s: String, ns: String): Int = {
    var n = 0
    breakable {
      for (i <- 0 until ns.length) {
        if (s.slice(i, i + 1) == ns.slice(i, i + 1)) {
          n = n + 1
        } else {
          break
        }
      }
    }
    n
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val s = StdIn.readLine

      val result = Result.stringSimilarity(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
