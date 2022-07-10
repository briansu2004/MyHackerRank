import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'designerPdfViewer' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY h
   *  2. STRING word
   */

  def designerPdfViewer(h: Array[Int], word: String): Int = {
    // Write your code here
    word.toCharArray().map(x => h(x - 'a')).max * word.length
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val h = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val word = StdIn.readLine

    val result = Result.designerPdfViewer(h, word)

    printWriter.println(result)

    printWriter.close()
  }
}
