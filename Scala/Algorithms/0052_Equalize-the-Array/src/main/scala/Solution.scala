import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'equalizeArray' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def equalizeArray(arr: Array[Int]): Int = {
    // Write your code here
    var max = 0
    for (i <- arr.indices) {
      max = Math.max(arr.map(x => x - arr(i)).count(x => x == 0), max)
    }
    arr.length - max
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.equalizeArray(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
