import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'introTutorial' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER V
   *  2. INTEGER_ARRAY arr
   */

  def introTutorial(V: Int, arr: Array[Int]): Int = {
    // Write your code here
    arr.indexOf(V)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val V = StdIn.readLine.trim.toInt

    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.introTutorial(V, arr)

    printWriter.println(result)

    printWriter.close()
  }
}
