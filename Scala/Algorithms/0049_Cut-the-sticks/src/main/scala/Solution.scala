import java.io._
import java.math._
import java.util._
import scala.collection.mutable
import scala.io._

object Result {

  /*
   * Complete the 'cutTheSticks' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def cutTheSticks(ar: Array[Int]): Array[Int] = {
    // Write your code here
    val que: mutable.Queue[Int] = mutable.Queue[Int]()

    while (ar.count(x => x > 0) > 1) {
      val shortest = ar.filter(x => x > 0).min
      que.enqueue(ar.count(x => x >= shortest))
      ar.mapInPlace(x => if (x - shortest > 0) x - shortest else 0)
    }

    if (ar.count(x => x > 0) == 1) {
      que.enqueue(1)
    }
    que.toArray
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.cutTheSticks(arr)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
