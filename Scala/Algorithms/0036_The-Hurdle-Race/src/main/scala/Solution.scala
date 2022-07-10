import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'hurdleRace' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY height
   */

  def hurdleRace(k: Int, height: Array[Int]): Int = {
    // Write your code here
    Math.max(height.max - k, 0)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val k = firstMultipleInput(1).toInt

    val height = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.hurdleRace(k, height)

    printWriter.println(result)

    printWriter.close()
  }
}
