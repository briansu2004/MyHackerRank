import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'pangrams' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def pangrams(s: String): String = {
    // Write your code here
    val summary: Array[Boolean] = Array.fill[Boolean](26)(false)

    for (c <- s.toLowerCase().filter(x => x != ' ')) {
      summary(c - 'a') = true
    }

    if (summary.count(x => !x) > 0) {
      return "not pangram"
    }
    "pangram"
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val s = StdIn.readLine

    val result = Result.pangrams(s)

    printWriter.println(result)

    printWriter.close()
  }
}
