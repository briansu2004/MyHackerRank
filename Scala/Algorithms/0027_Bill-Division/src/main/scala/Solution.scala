import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'bonAppetit' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY bill
   *  2. INTEGER k
   *  3. INTEGER b
   */

  def bonAppetit(bill: Array[Int], k: Int, b: Int): Unit = {
    // Write your code here
    val anna: Double = (bill.sum - bill(k)).toDouble / 2
    if (anna == b.toDouble) {
      println("Bon Appetit")
    } else {
      println((b - anna).toInt)
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val k = firstMultipleInput(1).toInt

    val bill = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val b = StdIn.readLine.trim.toInt

    Result.bonAppetit(bill, k, b)
  }
}
