import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'arrayManipulation' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY queries
   */

  def arrayManipulation(n: Int, queries: Array[Array[Int]]): Long = {
    // Write your code here
    val arr: Array[Long] = new Array[Long](n + 2)

    queries.foreach {
      line => {
        arr(line(0)) = arr(line(0)) + line(2)
        arr(line(1) + 1) = arr(line(1) + 1) - line(2)
      }
    }

    var maxValue: Long = Long.MinValue
    var sum = 0L
    for (i <- arr.indices) {
      sum = sum + arr(i)
      maxValue = math.max(maxValue, sum)
    }

    maxValue
  }

  def arrayManipulationSlow(n: Int, queries: Array[Array[Int]]): Long = {
    // Write your code here
    val arr: Array[Long] = new Array[Long](n)

    queries.foreach {
      line => {
        for (i <- line(0) - 1 until line(1)) {
          arr(i) = arr(i) + line(2)
        }
      }
    }

    //    arr.foldLeft(arr(0)) {
    //      case (max, e) => math.max(max, e)
    //    }
    // arr.toList.sortWith(_ > _).head
    // arr.toList.max
    //arr.reduceLeft(_ max _)
    arr.max
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val m = firstMultipleInput(1).toInt

    val queries = Array.ofDim[Int](m, 3)

    for (i <- 0 until m) {
      queries(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.arrayManipulation(n, queries)

    printWriter.println(result)

    printWriter.close()
  }
}
