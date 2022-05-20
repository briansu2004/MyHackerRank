import java.util._
import scala.collection.immutable._
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'matrixRotation' function below.
   *
   * The function accepts following parameters:
   *  1. 2D_INTEGER_ARRAY matrix
   *  2. INTEGER r
   */

  def matrixRotation(matrix: Array[Array[Int]], r: Int) {
    // Write your code here

    // temp matrix
    val m = matrix.length
    val n = matrix(0).length
    //val mat: Array[Array[Int]] = Array.ofDim[Int](m, n)
    var mat: List[List[Int]] = List()

    // # of layers
    val k = min(m, n) / 2

    // get the elements from the layer
    for (i <- 0 until k) {
      var temp: List[Int] = List()
      for (j <- i until n - i) {
        temp = temp :: matrix(i)(j) :: Nil
      }
      for (j <- i until m - i) {
        temp = temp :: matrix(j)(n - 1 - i) :: Nil
      }
      for (j <- i + 1 until n - i) {
        temp = temp :: matrix(m - 1 - i)(j) :: Nil
      }
      for (j <- i + 1 until m - i) {
        temp = temp :: matrix(j)(i) :: Nil
      }
      //mat = mat :: temp :: Nil
      mat = mat ::: temp
    }

    // rotate elements and place it in original matrix
    for (i <- 0 until k) {
      val row = mat(i)
      // find index after rotation
      val idx = r % len(row)
    }
  }

}

object Solution {
  def main(args: Array[String]) {
    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val m = firstMultipleInput(0).toInt

    val n = firstMultipleInput(1).toInt

    val r = firstMultipleInput(2).toInt

    val matrix = Array.ofDim[Int](m, n)

    for (i <- 0 until m) {
      matrix(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    Result.matrixRotation(matrix, r)
  }
}
