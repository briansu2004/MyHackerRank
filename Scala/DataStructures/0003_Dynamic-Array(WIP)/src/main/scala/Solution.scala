import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'dynamicArray' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY queries
   */

  def dynamicArray(n: Int, queries: Array[Array[Int]]): Array[Int] = {
    // Write your code here
    var lastAnswer = 0
    val arr: Array[List[Int]] = new Array[List[Int]](n)
    var outList: List[Int] = List()

    queries.foreach { line => {
      //printArray(x)
      val idx = (line(1) ^ lastAnswer) % n
      if (line(0) == 1) {
        // Query type 1
        if (arr(idx) == null || arr(idx).nonEmpty) {
          arr(idx) = List(line(2))
        } else {
          arr(idx) = arr(idx) :+ line(2)
        }
      } else if (line(0) == 2) {
        // Query type 2
        //lastAnswer = arr(idx)(line(2) % arr(idx).length)
        if (arr(idx) != null && arr(idx).nonEmpty) {
          lastAnswer = arr(idx)(line(2) % arr(idx).length)
          outList = outList :+ lastAnswer
        }
      }
    }
    }

    outList.toArray
  }

  def printArray(arr: Array[Int]): Unit = {
    //println(s"The array values:")
    arr.foreach(x => print(s"$x "))
    println()
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val q = firstMultipleInput(1).toInt

    val queries = Array.ofDim[Int](q, 3)

    for (i <- 0 until q) {
      queries(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.dynamicArray(n, queries)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
