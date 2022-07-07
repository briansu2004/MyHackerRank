import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'migratoryBirds' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def migratoryBirds(arr: Array[Int]): Int = {
    // Write your code here
    val cnt: Array[Int] = Array.fill[Int](5)(0)
    for (i <- arr.indices) {
      cnt(arr(i) - 1) = cnt(arr(i) - 1) + 1
    }

    var idx = 0
    for (i <- 1 until 5) {
      if (cnt(i) > cnt(idx)) {
        idx = i
      }
    }

    idx + 1
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val arrCount = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.migratoryBirds(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
