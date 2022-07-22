import java.io._
import java.util._
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'factorial' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  /* it is only for recursion so will be optimized later */
  def factorial(n: BigInt): BigInt = {
    // Write your code here
    if (n <= 1) {
      1
    } else {
      n * factorial(n - 1)
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val n: BigInt = BigInt(StdIn.readLine.trim)

    val result = Result.factorial(n)

    printWriter.println(result)

    printWriter.close()
  }
}
