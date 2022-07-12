import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'acmTeam' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts STRING_ARRAY topic as parameter.
   */

  def combine(s1: String, s2: String): Int = {
    var cnt = 0
    for (i <- s1.indices) {
      if ((s1(i).asDigit | s2(i).asDigit) == 1) {
        cnt += 1
      }
    }
    cnt
  }

  def acmTeam(topic: Array[String]): Array[Int] = {
    // Write your code here
    val res: Array[Int] = Array.fill[Int](topic(0).length)(0)
    for (i <- 0 until topic.length - 1) {
      for (j <- i + 1 until topic.length) {
        val cnt = combine(topic(i), topic(j))
        res(cnt - 1) += 1
      }
    }

    val max = res.filter(x => x > 0).takeRight(1)(0)
    val idx = res.indexOf(max) + 1

    Array(idx, max)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val m = firstMultipleInput(1).toInt

    val topic = Array.ofDim[String](n)

    for (i <- 0 until n) {
      val topicItem = StdIn.readLine
      topic(i) = topicItem
    }

    val result = Result.acmTeam(topic)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
