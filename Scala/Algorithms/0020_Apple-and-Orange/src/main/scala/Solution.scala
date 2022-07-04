import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'countApplesAndOranges' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER s
   *  2. INTEGER t
   *  3. INTEGER a
   *  4. INTEGER b
   *  5. INTEGER_ARRAY apples
   *  6. INTEGER_ARRAY oranges
   */

  def countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array[Int], oranges: Array[Int]): Unit = {
    // Write your code here
    println(apples.count(x => (a + x) >= s && (a + x) <= t))
    println(oranges.count(y => (b + y) >= s && (b + y) <= t))
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val s = firstMultipleInput(0).toInt

    val t = firstMultipleInput(1).toInt

    val secondMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val a = secondMultipleInput(0).toInt

    val b = secondMultipleInput(1).toInt

    val thirdMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val m = thirdMultipleInput(0).toInt

    val n = thirdMultipleInput(1).toInt

    val apples = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val oranges = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    Result.countApplesAndOranges(s, t, a, b, apples, oranges)
  }
}
