import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'jumpingOnClouds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY c as parameter.
   */

  def jumpingOnClouds(c: Array[Int]): Int = {
    // Write your code here
    var jumpCount = 0
    var i = 0

    while (i < c.length - 2) {
      if (c(i + 2) == 0) {
        jumpCount += 1
        i += 2
      } else {
        jumpCount += 2
        i += 3
      }
    }
    if (i != c.length - 1) {
      jumpCount += 1
    }

    jumpCount
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val c = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.jumpingOnClouds(c)

    printWriter.println(result)

    printWriter.close()
  }
}
