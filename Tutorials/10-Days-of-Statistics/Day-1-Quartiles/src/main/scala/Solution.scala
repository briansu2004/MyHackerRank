import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'quartiles' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */
  def getMedian(arr: Array[Int]): Int = {
    val len = arr.length
    val sa = arr.sorted

    if (arr.length % 2 == 0) {
      // even
      (sa(len / 2 - 1) + sa(len / 2)) / 2
    } else {
      // odd
      sa((len - 1) / 2)
    }
  }

  def quartiles(arr: Array[Int]): Array[Int] = {
    // Write your code here
    var first = 0
    var second = 0
    var third = 0
    val len = arr.length

    val sa = arr.sorted

    if (len % 2 == 0) {
      // even
      first = getMedian(sa.slice(0, len / 2))
      second = (sa(len / 2 - 1) + sa(len / 2)) / 2
      third = getMedian(sa.slice(len / 2, len))
    } else {
      // odd
      first = getMedian(sa.slice(0, (len - 1) / 2))
      second = sa((len - 1) / 2)
      third = getMedian(sa.slice((len + 1) / 2, len))
    }

    Array(first, second, third)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val data = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val res = Result.quartiles(data)

    printWriter.println(res.mkString("\n"))

    printWriter.close()
  }
}
