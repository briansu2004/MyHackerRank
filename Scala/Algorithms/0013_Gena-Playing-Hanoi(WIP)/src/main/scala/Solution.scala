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
   * Complete the 'hanoi' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY posts as parameter.
   */

  def hanoi(posts: Array[Int]): Int = {
    // Write your code here
    0
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val loc = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val res = Result.hanoi(loc)

    printWriter.println(res)

    printWriter.close()
  }
}
