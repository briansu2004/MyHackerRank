import java.io._
import java.math._
import java.util._
import scala.io._
import scala.util.control.Breaks



object Result {

  /*
   * Complete the 'longestSubarray' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def longestSubarray(arr: Array[Long]): Int = {
    if (arr.length <= 2) {
      return arr.length
    } else if (arr.length == 3) {
      if (arr(0) != arr(1) && arr(0) != arr(2) && arr(1) != arr(2)) {
        return 2
      } else if (arr(0) == arr(1) && arr(0) == arr(2) ) {
        return 2
      }
      return 3
    }

    var distinctCnt = 1
    var soFarMax = 2

    val loop = new Breaks
    loop.breakable {
      for (i <- 1 until arr.length - 3) {
        var maxLen = 2
        val xs: Array[Long] = arr.slice(i, i + 4)
        if (xs(1) == xs(0)) {
          distinctCnt = 1
        }
        if (xs(2) != xs(1) && xs(2) != xs(0) && xs(1) != xs(0)) {
          loop.break
        } else if (xs(2) == xs(1) && xs(2) == xs(0)) {
          loop.break
        } else {
          distinctCnt = 2
          maxLen = 3
          if (xs(3) == xs(2)) {
            loop.break
          } else {
            return 4
          }
        }

        soFarMax = Math.max(soFarMax, maxLen)
      }
    }

    soFarMax
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val arrCount = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[Long](arrCount)

    for (i <- 0 until arrCount) {
      val arrItem = StdIn.readLine.trim.toLong
      arr(i) = arrItem
    }

    val result = Result.longestSubarray(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
