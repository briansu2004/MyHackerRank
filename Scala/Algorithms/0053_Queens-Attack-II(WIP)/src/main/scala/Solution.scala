import java.io._
import java.lang.Math._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'queensAttack' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   *  3. INTEGER r_q
   *  4. INTEGER c_q
   *  5. 2D_INTEGER_ARRAY obstacles
   */

  def queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array[Array[Int]]): Int = {
    // Write your code here
    var rowLeftColumn = 0
    var rowLRightColumn = n + 1
    var columnUpRow = n + 1
    var columnDownRow = 0
    var diagTopLeftRow = r_q + min(n + 1 - r_q, n + 1 - c_q)
    var diagBottomRightRow = r_q - min(n + 1 - r_q, n + 1 - c_q)
    var diagTopRightRow = r_q + min(n + 1 - r_q, n + 1 - c_q)
    var diagBottomLeftRow = r_q - min(n + 1 - r_q, n + 1 - c_q)
    obstacles.foreach(x => {
      // row
      if (x(0) == r_q && x(1) < c_q) {
        rowLeftColumn = max(rowLeftColumn, x(1))
      } else if (x(0) == r_q && x(1) > c_q) {
        rowLRightColumn = min(rowLeftColumn, x(1))
      }
      // column
      if (x(1) == c_q && x(0) > r_q) {
        columnUpRow = min(columnUpRow, x(0))
      } else if (x(1) == c_q && x(0) < r_q) {
        columnDownRow = max(columnDownRow, x(0))
      }
      // diagonal - top/left to bottom/right
      if ((x(0) - r_q) == -(x(1) - c_q) && x(0) > r_q) {
        diagTopLeftRow = min(diagTopLeftRow, x(0))
      } else if ((x(0) - r_q) == -(x(1) - c_q) && x(0) < r_q) {
        diagBottomRightRow = max(diagBottomRightRow, x(0))
      }
      // diagonal - top/right to bottom/left
      if ((x(0) - r_q) == (x(1) - c_q) && x(0) > r_q) {
        diagTopRightRow = min(diagTopRightRow, x(0))
      } else if ((x(0) - r_q) == (x(1) - c_q) && x(0) < r_q) {
        diagBottomLeftRow = max(diagBottomLeftRow, x(0))
      }
    }
    )
    println(s"rowLeftColumn: $rowLeftColumn ; rowLRightColumn: $rowLRightColumn")
    println(s"columnUpRow: $columnUpRow ; columnDownRow: $columnDownRow")
    println(s"diagTopLeftRow: $diagTopLeftRow ; diagBottomRightRow: $diagBottomRightRow")
    println(s"diagTopRightRow: $diagTopRightRow ; diagBottomLeftRow: $diagBottomLeftRow")

    (rowLRightColumn - rowLeftColumn - 2) + (columnUpRow - columnDownRow - 2) + (diagTopLeftRow - diagBottomRightRow - 2) + (diagTopRightRow - diagBottomLeftRow - 2)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val k = firstMultipleInput(1).toInt

    val secondMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val r_q = secondMultipleInput(0).toInt

    val c_q = secondMultipleInput(1).toInt

    val obstacles = Array.ofDim[Int](k, 2)

    for (i <- 0 until k) {
      obstacles(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.queensAttack(n, k, r_q, c_q, obstacles)

    printWriter.println(result)

    printWriter.close()
  }
}
