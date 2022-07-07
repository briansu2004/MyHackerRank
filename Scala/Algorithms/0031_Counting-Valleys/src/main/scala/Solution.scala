import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'countingValleys' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER steps
   *  2. STRING path
   */

  def countingValleys(steps: Int, path: String): Int = {
    // Write your code here
    var cnt = 0
    var lvl = 0
    var inV: Boolean = false

    for (p <- path) {
      if (p == 'U') {
        lvl += 1
        if (inV && lvl >= 0) {
          cnt += 1
          inV = false
        }
      } else {
        lvl -= 1
        if (!inV && lvl < 0) {
          inV = true
        }
      }
    }

    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val steps = StdIn.readLine.trim.toInt

    val path = StdIn.readLine

    val result = Result.countingValleys(steps, path)

    printWriter.println(result)

    printWriter.close()
  }
}
