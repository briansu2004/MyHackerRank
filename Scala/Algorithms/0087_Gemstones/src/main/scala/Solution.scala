import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'gemstones' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING_ARRAY arr as parameter.
   */

  def gemstones(arr: Array[String]): Int = {
    // Write your code here
    val res: Array[Int] = Array.fill[Int](26)(0)
    for (i <- arr.indices) {
      arr(i).toCharArray.distinct.foreach(x => res(x - 'a') += 1)
    }
    res.count(x => x == arr.length)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = Array.ofDim[String](n)

    for (i <- 0 until n) {
      val arrItem = StdIn.readLine
      arr(i) = arrItem
    }

    val result = Result.gemstones(arr)

    printWriter.println(result)

    printWriter.close()
  }
}
