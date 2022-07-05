import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'getTotalX' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   */

  def getTotalX(a: Array[Int], b: Array[Int]): Int = {
    // Write your code here
    val f = lcm(a)
    val l = gcd(b)
    var cnt = 0

    var i = f
    while (i <= l) {
      if (l % i == 0) {
        cnt += 1
      }
      i += f
    }

    cnt
  }

  def gcd(a: Int, b: Int): Int = {
    var c = a
    var d = b
    while (d > 0) {
      val t = d
      d = c % d
      c = t
    }
    c
  }
  def gcd(a: Array[Int]): Int = {
    var n = a(0)
    for (i <- 1 until a.length) {
      n = gcd(n, a(i))
    }
    n
  }

  def lcm(a: Int, b: Int): Int = {
    a * (b / gcd(a, b))
  }
  def lcm(a: Array[Int]): Int = {
    var n = a(0)
    for (i <- 1 until a.length) {
      n = lcm(n, a(i))
    }
    n
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val m = firstMultipleInput(1).toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val brr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val total = Result.getTotalX(arr, brr)

    printWriter.println(total)

    printWriter.close()
  }
}
