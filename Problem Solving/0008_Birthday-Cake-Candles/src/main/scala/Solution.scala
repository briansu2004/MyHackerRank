import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'birthdayCakeCandles' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY candles as parameter.
   */

  def birthdayCakeCandles(candles: Array[Int]): Int = {
    // Write your code here
    var count = 0
    val max = candles.max
    for (i <- candles.indices) {
      if (candles(i) == max) {
        count = count + 1
      }
    }
    count
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val candlesCount = StdIn.readLine.trim.toInt

    val candles = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.birthdayCakeCandles(candles)

    printWriter.println(result)

    printWriter.close()
  }
}
