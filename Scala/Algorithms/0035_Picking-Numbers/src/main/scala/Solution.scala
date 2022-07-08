import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'pickingNumbers' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  def pickingNumbers(a: Array[Int]): Int = {
    // Write your code here
    var maxLen = 2
    for (i <- 0 until a.length - 1) {
      val b: Array[Int] = a.map(x => x - a(i)).filter(y => Math.abs(y) <= 1)
      maxLen = Math.max(Math.max(b.count(x => x >= 0), b.count(x => x <= 0)), maxLen)
    }
    maxLen
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.pickingNumbers(a)

    printWriter.println(result)

    printWriter.close()
  }
}
