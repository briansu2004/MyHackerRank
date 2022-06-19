import java.io._
import scala.io._
import scala.util.control.Breaks.{break, breakable}

object Result {

  /*
   * Complete the 'shortPalindrome' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def shortPalindrome(s: String): Int = {
    // Write your code here
    var cnt = 0
    val len = s.length
    for (l1 <- 0 to len - 4) {
      val s1 = s(l1)
      for (r1 <- len - 1 to l1 + 3 by -1) {
        breakable {
          val s4 = s(r1)
          if (s4 != s1) {
            break
          } else {
            // found 1 and 4
            for (l2 <- l1 + 1 to r1 - 2) {
              val s2 = s(l2)
              for (r2 <- r1 - 1 to l2 + 1 by -1) {
                breakable {
                  val s3 = s(r2)
                  if (s3 != s2) {
                    break
                  } else {
                    // found 2 and 3 as well
                    //println(s"$l1 $l2 $r2 $r1")
                    cnt = cnt + 1
                  }
                }
              }
            }
          }
        }
      }
    }

    cnt % 1000000007
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val result = Result.shortPalindrome(s)

    printWriter.println(result)

    printWriter.close()
  }
}
