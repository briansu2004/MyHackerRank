import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'alternatingCharacters' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def alternatingCharacters(s: String): Int = {
    // Write your code here
    var cnt = 0
    val arr = s.toCharArray.map(x => x - 'a')
    for (i <- 1 until s.length) {
      if (arr(i) == arr(i - 1)) {
        cnt += 1
      }
    }
    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = StdIn.readLine

      val result = Result.alternatingCharacters(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
