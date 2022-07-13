import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'taumBday' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER b
   *  2. INTEGER w
   *  3. INTEGER bc
   *  4. INTEGER wc
   *  5. INTEGER z
   */

  def taumBday(b: Long, w: Long, bc: Long, wc: Long, z: Long): Long = {
    // Write your code here
    var wCost = 0L
    var bCost = 0L

    if (bc + z < wc) {
      wCost = (bc + z) * w
    } else {
      wCost = wc * w
    }

    if (wc + z < bc) {
      bCost = (wc + z) * b
    } else {
      bCost = bc * b
    }

    wCost + bCost
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val b = firstMultipleInput(0).toLong

      val w = firstMultipleInput(1).toLong

      val secondMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val bc = secondMultipleInput(0).toLong

      val wc = secondMultipleInput(1).toLong

      val z = secondMultipleInput(2).toLong

      val result = Result.taumBday(b, w, bc, wc, z)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
