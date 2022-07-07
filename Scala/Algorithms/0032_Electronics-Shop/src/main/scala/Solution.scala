import java.io.PrintWriter
import scala.util.control.Breaks

object Solution {

  /*
   * Complete the getMoneySpent function below.
   */
  def getMoneySpent(keyboards: Array[Int], drives: Array[Int], b: Int): Int = {
    /*
     * Write your code here.
     */
    val kb = keyboards.filter(x => x < b).sorted
    val drv = drives.filter(x => x < b).sorted
    var result = -1

    val loop1 = new Breaks
    val loop2 = new Breaks
    loop1.breakable {
      for (i <- kb.length - 1 to 0 by -1) {
        loop2.breakable {
          for (j <- drv.length - 1 to 0 by -1) {
            if (kb(i) + drv(j) == b) {
              return b
            }
            if (kb(i) + drv(j) < b) {
              result = Math.max(result, kb(i) + drv(j))
              loop2.break
            }
          }
        }
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(System.out)

    val bnm = stdin.readLine.split(" ")

    val b = bnm(0).trim.toInt

    val n = bnm(1).trim.toInt

    val m = bnm(2).trim.toInt

    val keyboards = stdin.readLine.split(" ").map(_.trim.toInt)

    val drives = stdin.readLine.split(" ").map(_.trim.toInt)
    /*
     * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
     */

    val moneySpent = getMoneySpent(keyboards, drives, b)

    printWriter.println(moneySpent)

    printWriter.close()
  }
}
