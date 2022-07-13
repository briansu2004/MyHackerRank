import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'beautifulTriplets' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER d
   *  2. INTEGER_ARRAY arr
   */

  def beautifulTriplets(d: Int, arr: Array[Int]): Int = {
    // Write your code here
    var cnt = 0
    var i = 0

    while (i < arr.length) {
      val cnt1 = arr.count(x => x == arr(i))
      val cnt2 = arr.count(x => x == arr(i) + d)
      val cnt3 = arr.count(x => x == arr(i) + d * 2)
      if (cnt2 > 0 && cnt3 > 0) {
        cnt += cnt1 * cnt2 * cnt3
      }
      i += cnt1
    }

    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val d = firstMultipleInput(1).toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.beautifulTriplets(d, arr)

    printWriter.println(result)

    printWriter.close()
  }
}
