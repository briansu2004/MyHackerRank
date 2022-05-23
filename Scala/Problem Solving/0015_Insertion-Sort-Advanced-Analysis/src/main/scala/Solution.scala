import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'insertionSort' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def insertionSort(arr: Array[Int]): BigInt = {
    // Write your code here
    var cnt: BigInt = 0
    for (i <- 0 until arr.length - 1) {
      var j = i + 1
      while (j > 0 && arr(j - 1) > arr(j)) {
        val t = arr(j - 1)
        arr(j - 1) = arr(j)
        arr(j) = t
        cnt = cnt + 1
        //println(s"Move $j to ${(j - 1)}; i: $i; Count: $cnt")
        j = j - 1
      }
    }
    cnt
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = StdIn.readLine.trim.toInt

      val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      val result = Result.insertionSort(arr)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
