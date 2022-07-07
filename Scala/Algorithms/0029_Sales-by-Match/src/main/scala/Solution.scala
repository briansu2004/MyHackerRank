import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'sockMerchant' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY ar
   */

  def sockMerchant(n: Int, ar: Array[Int]): Int = {
    // Write your code here
    var cnt = 0
    val socks: Array[Int] = Array.fill[Int](100)(0)

    ar.map(x => socks(x - 1) += 1)
    socks.map(x => cnt += (x - x % 2) / 2)

    cnt
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val ar = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.sockMerchant(n, ar)

    printWriter.println(result)

    printWriter.close()
  }
}
