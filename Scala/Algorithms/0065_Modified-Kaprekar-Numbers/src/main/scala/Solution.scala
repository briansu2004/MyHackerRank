import java.math._
import java.util._
import java.util.concurrent._
import scala.collection.mutable
import scala.io._

object Result {

  /*
   * Complete the 'kaprekarNumbers' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER p
   *  2. INTEGER q
   */

  def kaprekarNumbers(p: Long, q: Long): Unit = {
    // Write your code here
    // 5292 is invalid in HackerRank
    // but it is valid in Wiki
    // If the square has an odd number of digits, the right piece should have more digits than the left piece
    val que: mutable.Queue[Long] = mutable.Queue[Long]()
    for (i <- p to q) {
      val c = (i * i).toString.toCharArray.map(x => x.asDigit)
      val l = c.length
      if (l < 3) {
        if (c.sum == i) {
          que.enqueue(i)
        }
      } else {
        val n1 = c.slice(0, (l - l % 2) / 2).mkString("").toLong
        val n2 = c.slice((l - l % 2) / 2, l).mkString("").toLong
        if (n1 > 0 && n2 > 0 && n1 + n2 == i) {
          que.enqueue(i)
        }
      }
    }

    if (que.nonEmpty) {
      println(que.mkString(" "))
    } else {
      println("INVALID RANGE")
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val p = StdIn.readLine.trim.toLong

    val q = StdIn.readLine.trim.toLong

    Result.kaprekarNumbers(p, q)
  }
}
