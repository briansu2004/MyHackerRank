import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'utopianTree' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  val TheUtopianTree: LazyList[Int] = {
    def f: LazyList[Int] = {
      1 #:: f.zipWithIndex.map {
        n => if (n._2 % 2 == 0) n._1 * 2 else n._1 + 1
      }
    }
    f
  }

  def utopianTree(n: Int): Int = {
    // Write your code here
    TheUtopianTree(n)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = StdIn.readLine.trim.toInt

      val result = Result.utopianTree(n)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
