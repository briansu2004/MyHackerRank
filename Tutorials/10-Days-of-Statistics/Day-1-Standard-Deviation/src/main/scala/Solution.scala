import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'quartiles' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */
  def stdDev(arr: Array[Int]): Double = {
    // Print your answers to 1 decimal place within this function
    val len = arr.length
    val mean = arr.sum.toDouble / len

    var sum: Double = 0
    for (i <- arr.indices) {
      sum = sum + (arr(i).toDouble - mean) * (arr(i).toDouble - mean)
    }

    math.sqrt(sum / len)
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val vals = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val res = Result.stdDev(vals)

    printWriter.println(f"$res%.1f")

    printWriter.close()
  }
}
