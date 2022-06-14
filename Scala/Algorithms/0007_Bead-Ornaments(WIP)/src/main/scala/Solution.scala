import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'beadOrnaments' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY b as parameter.
   */

  def beadOrnaments(b: Array[Int]): Int = {
    // Write your code here

    0
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val bCount = StdIn.readLine.trim.toInt

      val b = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      val result = Result.beadOrnaments(b)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
