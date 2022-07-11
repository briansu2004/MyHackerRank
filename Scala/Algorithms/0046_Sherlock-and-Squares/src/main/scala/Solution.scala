import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'squares' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER a
   *  2. INTEGER b
   */

  //  val AllSquares: LazyList[Int] = {
  //    def f: LazyList[Int] = {
  //      1 #:: f.zipWithIndex.map {
  //        n => (n._2 + 2) * (n._2 + 2)
  //      }
  //    }
  //    f
  //  }
  //  def squares1(a: Int, b: Int): Int = {
  //    // Write your code here
  //    //AllSquares.filter(n => n >=a && n <= b).size //java.lang.StackOverflowError
  //    0
  //  }

  def squares(a: Int, b: Int): Int = {
    // Write your code here
    //AllSquares.filter(n => n >=a && n <= b).size //java.lang.StackOverflowError
//    val i = Math.sqrt(a).ceil.toInt
//    val j = Math.sqrt(b).floor.toInt
//    var n = j - i + 1
//    n
    Math.sqrt(b).floor.toInt - Math.sqrt(a).ceil.toInt + 1
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val a = firstMultipleInput(0).toInt

      val b = firstMultipleInput(1).toInt

      val result = Result.squares(a, b)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
