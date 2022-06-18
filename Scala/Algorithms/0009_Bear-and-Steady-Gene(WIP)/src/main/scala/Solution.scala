import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'steadyGene' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING gene as parameter.
   */

  def steadyGene(gene: String): Int = {
    // Write your code here

    0
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val gene = StdIn.readLine

    val result = Result.steadyGene(gene)

    printWriter.println(result)

    printWriter.close()
  }
}
