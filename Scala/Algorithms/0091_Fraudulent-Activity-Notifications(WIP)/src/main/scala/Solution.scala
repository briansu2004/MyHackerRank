import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'activityNotifications' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY expenditure
   *  2. INTEGER d
   */

  // TLE problem
  def getMedian(arr: Array[Int]): Double = {
    val a = arr.sorted
    val l = arr.length
    if (l % 2 == 0) {
      (a(l / 2 - 1) + a(l / 2)).toDouble / 2
    } else {
      a((l - 1) / 2).toDouble
    }
  }

  def activityNotifications(expenditure: Array[Int], d: Int): Int = {
    // Write your code here
    var cnt = 0
    for (i <- d until expenditure.length) {
      val median = getMedian(expenditure.slice(i - d, i))
      if (expenditure(i).toDouble >= median * 2) {
        cnt += 1
      }
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

    val expenditure = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.activityNotifications(expenditure, d)

    printWriter.println(result)

    printWriter.close()
  }
}
