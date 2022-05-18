import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'rotateLeft' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER d
   *  2. INTEGER_ARRAY arr
   */

  def rotateLeft(d: Int, arr: Array[Int]): Array[Int] = {
    // Write your code here
    val newArr: Array[Int] = arr.clone()
    for (i <- 0 until arr.length) {
      val newPos = (i + arr.length - d) % arr.length
      newArr(newPos) = arr(i)
    }
    arr
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val d = firstMultipleInput(1).toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.rotateLeft(d, arr)

    printWriter.println(result.mkString(" "))

    printWriter.close()
  }
}
