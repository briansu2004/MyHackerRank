import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.concurrent._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.reflect._
import scala.sys._
import scala.util.matching._

object Result {

  /*
   * Complete the 'formingMagicSquare' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts 2D_INTEGER_ARRAY s as parameter.
   */

  def formingMagicSquare(s: Array[Array[Int]]): Int = {
    // Write your code here


    0
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val s = Array.ofDim[Int](3, 3)

    for (i <- 0 until 3) {
      s(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.formingMagicSquare(s)

    printWriter.println(result)

    printWriter.close()
  }
}
