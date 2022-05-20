import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'timeConversion' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def timeConversion(s: String): String = {
    // Write your code here
    // 1. special
    // 2. check AM PM
    // 3. convert
    // Note:
    // - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
    // - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.

    if (s.equalsIgnoreCase("12:00:00PM")) {
      "12:00:00"
    } else {
      val ampm = s.slice(s.length - 2, s.length)
      val h = s.slice(0, 2).toInt

      if (ampm.equalsIgnoreCase("AM")) {
        //AM
        if (h == 12) {
          "00" + s.slice(2, s.length - 2)
        } else {
          s.slice(0, s.length - 2)
        }
      } else {
        //PM
        if (h == 12) {
          "12" + s.slice(2, s.length - 2)
        } else {
          (h + 12).toString + s.slice(2, s.length - 2)
        }
      }
    }
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val result = Result.timeConversion(s)

    printWriter.println(result)

    printWriter.close()
  }
}
