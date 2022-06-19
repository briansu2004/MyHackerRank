import java.io._
import scala.io._

object Result {
  /*
   * Complete the 'interQuartile' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY values
   *  2. INTEGER_ARRAY freqs
   */
  def getMedian(arr: Array[Int]): Float = {
    val len = arr.length
    val sa = arr.sorted

    if (arr.length % 2 == 0) {
      // even
      (sa(len / 2 - 1).toFloat + sa(len / 2).toFloat) / 2
    } else {
      // odd
      sa((len - 1) / 2).toFloat
    }
  }

  def interQuartile(values: Array[Int], freqs: Array[Int]): Float = {
    // Print your answer to 1 decimal place within this function
    val len = freqs.sum
    val arr = Array.ofDim[Int](len)
    var k = 0

    for (i <- values.indices) {
      for (_ <- 0 until freqs(i)) {
        arr(k) = values(i)
        k = k + 1
      }
    }

    val sa = arr.sorted

    var first: Float = 0
    var third: Float = 0

    if (len % 2 == 0) {
      // even
      first = getMedian(sa.slice(0, len / 2))
      third = getMedian(sa.slice(len / 2, len))
    } else {
      // odd
      first = getMedian(sa.slice(0, (len - 1) / 2))
      third = getMedian(sa.slice((len + 1) / 2, len))
    }

    third - first
  }
}

object Solution {
  def main(args: Array[String]): Unit = {

//    val n = StdIn.readLine.trim.toInt
//
//    val val = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
//
//    val freq = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
//
//    Result.interQuartile(val, freq)

    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val v = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val freq = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val res =  Result.interQuartile(v, freq)

    printWriter.println(res)

    printWriter.close()
  }
}
