import java.io._
import java.math._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'workbook' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER k
   *  3. INTEGER_ARRAY arr
   */

  def workbook(n: Int, k: Int, arr: Array[Int]): Int = {
    // Write your code here
    var cnt = 0
    var pageNo = 0

    // for each page (# is pageNo)
    // starts from 1 + (pageNo - 1) * k
    // ends up to pageNo * k
    for (i <- 0 until n) {
      var newPageNo = 0
      for (j <- 1 to (arr(i) - arr(i) % k) / k) {
        pageNo += 1
        newPageNo += 1
        if (pageNo >= (1 + (newPageNo - 1) * k) && pageNo <= newPageNo * k) {
          cnt += 1
        }
      }
      if (arr(i) % k > 0) {
        pageNo += 1
        newPageNo += 1
        if (pageNo >= (1 + (newPageNo - 1) * k) && pageNo <= arr(i) % k + (newPageNo - 1) * k) {
          cnt += 1
        }
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

    val k = firstMultipleInput(1).toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.workbook(n, k, arr)

    printWriter.println(result)

    printWriter.close()
  }
}
