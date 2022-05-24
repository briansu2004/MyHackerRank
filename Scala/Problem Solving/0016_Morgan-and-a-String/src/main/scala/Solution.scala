import java.io._
import scala.collection.mutable._
import scala.io._

object Result {

  /*
   * Complete the 'morganAndString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING a
   *  2. STRING b
   */

  def morganAndStringFail(a: String, b: String): String = {
    // Write your code here
    var i = 0
    var j = 0
    var n = 0
    var result: ListBuffer[Char] = new ListBuffer[Char]()
    while (i < a.length && j < b.length) {
      if (a.charAt(i) <= b.charAt(j)) {
        result += a.charAt(i)
        i += 1
      } else { //a.charAt(i) > b.charAt(j)
        result += b.charAt(j)
        j += 1
      }
    }
    if (i < a.length && j == b.length) {
      result.toList.mkString("") + a.substring(i, a.length)
    } else if (i == a.length && j < b.length) {
      result.toList.mkString("") + b.substring(j, b.length)
    } else {
      result.toList.mkString("")
    }
  }

  def morganAndString(x: String, y: String): String = {
    // Write your code here
    var a = x + "Z";
    var b = y + "Z";
    //println(s"Before: $a | $b")
    (for (i <- 0 until (a.length + b.length - 2)) yield {
      if (a < b) {
        a.charAt(0)
        a = a.substring(1, a.length)
        //println(s"$a | $b")
      } else {
        b.charAt(0)
        b = b.substring(1, b.length)
        //println(s"$a | $b")
      }
    }).mkString("")
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val a = StdIn.readLine

      val b = StdIn.readLine

      val result = Result.morganAndString(a, b)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
