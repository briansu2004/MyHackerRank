import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'camelcase' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def camelcase(s: String): Int = {
    // Write your code here
    s.toCharArray.count(x => x < 'a') + 1
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val s = StdIn.readLine

    val result = Result.camelcase(s)

    printWriter.println(result)

    printWriter.close()
  }
}
