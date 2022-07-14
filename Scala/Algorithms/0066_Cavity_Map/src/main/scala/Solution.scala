import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'cavityMap' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts STRING_ARRAY grid as parameter.
   */

  def cavityMap(grid: Array[String]): Array[String] = {
    // Write your code here
    val res = grid.clone()
    val l = grid.length

    for (i <- 1 until l - 1) {
      for (j <- 1 until l - 1) {
        if (res(i)(j).asDigit > res(i)(j - 1).asDigit && res(i)(j).asDigit > res(i)(j + 1).asDigit && res(i)(j)
          .asDigit > res(i - 1)(j).asDigit && res(i)(j)
          .asDigit > res(i + 1)(j).asDigit) {
          res(i) = res(i).slice(0, j) + 'X' + res(i).slice(j + 1, l)
        }
      }
    }

    res
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val grid = Array.ofDim[String](n)

    for (i <- 0 until n) {
      val gridItem = StdIn.readLine
      grid(i) = gridItem
    }

    val result = Result.cavityMap(grid)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
