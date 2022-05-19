import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'reverseArray' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  def reverseArray(a: Array[Int]): Array[Int] = {
    // Write your code here
    println(s"Before the reversion, the array was:")
    a.foreach(x => print(s"$x "))

    val n = a.length
    var tmp: Int = 0
    for (i <- 0 until (n - n % 2) / 2) {
      tmp = a(i)
      a(i) = a(n - i - 1)
      a(n - i -1) = tmp
    }

    println(s"Reversed array is:")
    a.foreach(x => print(s"$x "))
    println()

    a
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val arrCount = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val res = Result.reverseArray(arr)

    printWriter.println(res.mkString(" "))

    printWriter.close()
  }
}
