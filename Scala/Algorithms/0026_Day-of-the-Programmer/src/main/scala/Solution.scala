import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'dayOfProgrammer' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts INTEGER year as parameter.
   */
  def isLeap(year: Int): Boolean = {
    if (year >= 1919 && (year % 400 == 0 || (year % 4 == 0 && year % 100 > 0))) {
      return true
    } else if (year < 1919 && year % 4 == 0) {
      return true
    }
    false
  }

  def dayOfProgrammer(year: Int): String = {
    // Write your code here
    if (year == 1918) {
      return "26.09." + year
    }
    if (isLeap(year)) {
      return "12.09." + year
    }
    "13.09." + year
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val year = StdIn.readLine.trim.toInt

    val result = Result.dayOfProgrammer(year)

    printWriter.println(result)

    printWriter.close()
  }
}
