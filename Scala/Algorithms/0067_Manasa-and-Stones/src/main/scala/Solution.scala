import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.collection.mutable
import scala.io._

object Result {

  /*
   * Complete the 'stones' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER a
   *  3. INTEGER b
   */

  def stones(n: Int, a: Int, b: Int): Array[Int] = {
    // Write your code here
    if (n < 3) {
      Array(a, b)
    }

    // the 1st is: (n - 1) * a
    // the last is: (n - 1) * b
    val que: mutable.Queue[Int] = mutable.Queue[Int]()

    for (i <- 0 to n - 1) {
      val newVal = (n - 1 - i) * a + i * b
      // de-duplicate
      if (!que.contains(newVal)) {
        que.enqueue(newVal)
      }
    }

    que.toArray.sorted
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val T = StdIn.readLine.trim.toInt

    for (i <- 1 to T) {
      val n = StdIn.readLine.trim.toInt

      val a = StdIn.readLine.trim.toInt

      val b = StdIn.readLine.trim.toInt

      val result = Result.stones(n, a, b)

      printWriter.println(result.mkString(" "))
    }

    printWriter.close()
  }
}
