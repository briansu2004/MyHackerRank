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
   * Complete the 'minimumLoss' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts LONG_INTEGER_ARRAY price as parameter.
   */

  def minimumLoss(price: Array[Long]): Int = {
    // Write your code here

    0
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val price = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toLong)

    val result = Result.minimumLoss(price)

    printWriter.println(result)

    printWriter.close()
  }
}
