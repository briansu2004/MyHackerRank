import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.collection.mutable
import scala.io._

object Result {

  /*
   * Complete the 'bitwiseAnd' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER N
   *  2. INTEGER K
   */

  // TLE problem
  def bitwiseAnd1(N: Int, K: Int): Int = {
    // Write your code here
    var max = 0
    val arr: Array[Int] = (1 to N).toArray
    val com = arr.combinations(2)
    while (com.hasNext) {
      val l = com.next()
      val res = l(0) & l(1)
      max = Math.max(max, res)
    }
    max
  }

  // TLE problem still
  def bitwiseAnd2(N: Int, K: Int): Int = {
    // Write your code here
    val que: mutable.Queue[Int] = mutable.Queue[Int]()
    val arr: Array[Int] = (1 to N).toArray
    val com = arr.combinations(2)
    while (com.hasNext) {
      val l = com.next()
      que.enqueue(l(0) & l(1))
    }
    que.filter(x => x < K).max
  }

  // looks like combinations is very slow!
  def bitwiseAnd3(N: Int, K: Int): Int = {
    // Write your code here
    var max = 0
    val arr: Array[Int] = (1 to N).toArray
    val com = arr.combinations(2)
    while (com.hasNext) {
      val l = com.next()
      val res = l(0) & l(1)
      if (res == K - 1) {
        return res
      } else if (res < K - 1) {
        max = Math.max(max, res)
      }
    }
    max
  }

  // use 2 loops instead of combinations
  def bitwiseAnd(N: Int, K: Int): Int = {
    // Write your code here
    var max = 0
    val arr: Array[Int] = (1 to N).toArray
    for (i <- 0 until N - 1) {
      for (j <- i + 1 until N) {
        val res = arr(i) & arr(j)
        if (res == K - 1) {
          return res
        } else if (res < K - 1) {
          max = Math.max(max, res)
        }
      }
    }
    max
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val count = firstMultipleInput(0).toInt

      val lim = firstMultipleInput(1).toInt

      val res = Result.bitwiseAnd(count, lim)

      printWriter.println(res)
    }

    printWriter.close()
  }
}
