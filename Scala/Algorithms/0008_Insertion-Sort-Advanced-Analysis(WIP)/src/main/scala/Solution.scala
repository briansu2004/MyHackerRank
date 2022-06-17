import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'insertionSort' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def insertionSort(arr: Array[Int]): Int = {
    // Write your code here
    var n = 0

    //println(s"Before the insert sorting: ${arr.mkString(",")}")
    for (i <- 1 until arr.length) {
      for (j <- i to 1 by -1)
        if (arr(j - 1) > arr(j)) {
          //println(s"Swap ${j-1} and $j")
          swap(arr, j - 1, j)
          n = n + 1
        }
    }
    //println(s"After the insert sorting: ${arr.mkString(",")}")

    n
  }

  def swap(arr: Array[Int], x: Int, y: Int): Unit = {
    val t = arr(x)
    arr(x) = arr(y)
    arr(y) = t
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

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
