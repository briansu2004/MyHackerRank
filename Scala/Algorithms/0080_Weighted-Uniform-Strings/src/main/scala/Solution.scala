import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.collection.{immutable, mutable}
import scala.io._

object Result {

  /*
   * Complete the 'weightedUniformStrings' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER_ARRAY queries
   */
  // Queue got TLE problem!
  def weightedUniformStringsWithQueue(s: String, queries: Array[Int]): Array[String] = {
    // Write your code here
    val carr: Array[Int] = s.toCharArray.map(x => x - 'a' + 1)
    val que: mutable.Queue[Int] = mutable.Queue[Int]()
    var lastNo = 0
    var cnt = 1
    for (i <- carr) {
      if (i != lastNo) {
        que.enqueue(i)
        cnt = 1
        lastNo = i
      } else {
        cnt += 1
        que.enqueue(i * cnt)
      }
    }
    queries.map(x => if (que.contains(x)) "Yes" else "No")
  }

  // Set resolved TLE problem!
  def weightedUniformStrings(s: String, queries: Array[Int]): Array[String] = {
    // Write your code here
    val carr: Array[Int] = s.toCharArray.map(x => x - 'a' + 1)
    var se: immutable.Set[Int] = immutable.Set[Int]()
    var lastNo = 0
    var cnt = 1
    for (i <- carr) {
      if (i != lastNo) {
        se += i
        cnt = 1
        lastNo = i
      } else {
        cnt += 1
        se += i * cnt
      }
    }
    queries.map(x => if (se.contains(x)) "Yes" else "No")
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val s = StdIn.readLine

    val queriesCount = StdIn.readLine.trim.toInt

    val queries = Array.ofDim[Int](queriesCount)

    for (i <- 0 until queriesCount) {
      val queriesItem = StdIn.readLine.trim.toInt
      queries(i) = queriesItem
    }

    val result = Result.weightedUniformStrings(s, queries)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
