import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Logic {

  /*
   * Complete the 'beautifulBinaryString' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING b as parameter.
   */

  def beautifulBinaryString(b: String): Int = {
    // Write your code here
    var cnt = 0
    val arr = b.toCharArray.map(x => x.asDigit)
    var i = 0
    while (i + 2 < b.length) {
      if (arr(i) == 0 && arr(i + 1) == 1 && arr(i + 2) == 0) {
        cnt += 1
        i += 3
      } else {
        i += 1
      }
    }
    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val b = StdIn.readLine

    val result = Logic.beautifulBinaryString(b)

    printWriter.println(result)

    printWriter.close()
  }
}
