import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.collection.mutable
import scala.io._

object Result {

  /*
   * Complete the 'funnyString' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def funnyString(s: String): String = {
    // Write your code here
    val arr = s.toCharArray.map(x => x - s(0))
    val myStack: mutable.Stack[Int] = mutable.Stack[Int]()
    val myQueue: mutable.Queue[Int] = mutable.Queue[Int]()

    for (i <- 1 until s.length) {
      val diff = Math.abs(arr(i) - arr(i - 1))
      myStack.push(diff)
      myQueue.enqueue(diff)
    }

    if (myStack.mkString(",") == myQueue.mkString(",")) {
      return "Funny"
    }
    "Not Funny"
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val s = StdIn.readLine

      val result = Result.funnyString(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
