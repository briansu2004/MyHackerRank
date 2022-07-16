import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'marsExploration' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def marsExploration(s: String): Int = {
    // Write your code here
    var cnt = 0
    for (i <- 0 until s.length / 3) {
      if (s(i * 3) != 'S') {
        cnt += 1
      }
      if (s(i * 3 + 1) != 'O') {
        cnt += 1
      }
      if (s(i * 3 + 2) != 'S') {
        cnt += 1
      }
    }
    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val s = StdIn.readLine

    val result = Result.marsExploration(s)

    printWriter.println(result)

    printWriter.close()
  }
}
