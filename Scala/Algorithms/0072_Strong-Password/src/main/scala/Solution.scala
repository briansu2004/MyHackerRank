import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'minimumNumber' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. STRING password
   */

  def minimumNumber(n: Int, password: String): Int = {
    // Return the minimum number of characters to make the password strong
    val forLen = if (n < 6) 6 - n else 0
    val forDigit = if (password.toCharArray.count(x => x.asDigit >= 0 && x.asDigit <= 9) < 1) 1 else 0
    val forLowerCase = if (password.toCharArray.count(x => x >= 'a' && x <= 'z') < 1) 1 else 0
    val forUpperCase = if (password.toCharArray.count(x => x >= 'A' && x <= 'Z') < 1) 1 else 0
    val forSpecial = if (password.toCharArray.count(x => "!@#$%^&*()-+".indexOf(x) >= 0) < 1) 1 else 0

    Math.max(forDigit + forLowerCase + forUpperCase + forSpecial, forLen)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val password = StdIn.readLine

    val answer = Result.minimumNumber(n, password)

    printWriter.println(answer)

    printWriter.close()
  }
}
