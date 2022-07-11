import java.io.PrintWriter
import scala.io._

object Result {

  /*
   * Complete the 'nonDivisibleSubset' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY s
   */

  def nonDivisibleSubset(k: Int, s: Array[Int]): Int = {
    // Write your code here
    var nds: Set[Int] = Set[Int]()
    val l = s.length

    for (i <- 1 until l - 1) {
      for (j <- i until l) {
        if ((s(i) + s(j)) % k > 0) {
          nds += s(i)
          nds += s(j)
        }
      }
    }

    nds.size
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val k = firstMultipleInput(1).toInt

    val s = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.nonDivisibleSubset(k, s)

    printWriter.println(result)

    printWriter.close()
  }
}
