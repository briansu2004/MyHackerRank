import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'matchingStrings' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY strings
   *  2. STRING_ARRAY queries
   */

  def matchingStrings(strings: Array[String], queries: Array[String]): Array[Int] = {
    // Write your code here
    val queryResult: Array[Int] = new Array[Int](queries.length)

    for (i <- strings.indices) {
      for (j <- queries.indices) {
        if (strings(i) == queries(j)) {
          queryResult(j) = queryResult(j) + 1
        }
      }
    }

    queryResult
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val stringsCount = StdIn.readLine.trim.toInt

    val strings = Array.ofDim[String](stringsCount)

    for (i <- 0 until stringsCount) {
      val stringsItem = StdIn.readLine
      strings(i) = stringsItem
    }

    val queriesCount = StdIn.readLine.trim.toInt

    val queries = Array.ofDim[String](queriesCount)

    for (i <- 0 until queriesCount) {
      val queriesItem = StdIn.readLine
      queries(i) = queriesItem
    }

    val res = Result.matchingStrings(strings, queries)

    printWriter.println(res.mkString("\n"))

    printWriter.close()
  }
}
