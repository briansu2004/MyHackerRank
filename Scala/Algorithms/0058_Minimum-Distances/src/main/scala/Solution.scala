import java.io._
import java.math._
import java.util._
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'minimumDistances' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  def minimumDistances(a: Array[Int]): Int = {
    // Write your code here
    var res = Int.MaxValue

    var i = 0
    while (i < a.length) {
      if (a(i) > 0) {
        val cnt = a.count(x => x == a(i))
        if (cnt > 1) {
          res = min(res, a.lastIndexOf(a(i)) - i)
          a.mapInPlace(x => if (x == a(i)) 0 else x)
        }
      }
      i += 1
    }

    if (res == Int.MaxValue) {
      res = -1
    }
    res
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.minimumDistances(a)

    printWriter.println(result)

    printWriter.close()
  }
}
