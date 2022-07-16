import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'hackerrankInString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def hackerrankInString(s: String): String = {
    // Write your code here
    val hk = "hackerrank"
    val arr = s.toCharArray.filter(x => hk.contains(x))
    var idx = 0
    for (c <- hk.indices) {
      if (c > 0 && hk(c - 1) == hk(c)) {
        idx += 1
      }
      idx = arr.indexOf(hk(c), idx)
      if (idx < 0) {
        return "NO"
      }
    }
    "YES"
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = StdIn.readLine

      val result = Result.hackerrankInString(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
