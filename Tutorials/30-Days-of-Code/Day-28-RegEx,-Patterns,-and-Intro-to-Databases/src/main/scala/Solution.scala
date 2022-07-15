import java.math._
import java.util._
import java.util.concurrent._
import scala.collection.mutable
import scala.io._

object Solution {
  def main(args: Array[String]): Unit = {
    val N = StdIn.readLine.trim.toInt

    val que: mutable.Queue[String] = mutable.Queue[String]()
    val pattern = "[a-z.]+@gmail.com".r

    for (i <- 1 to N) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val firstName = firstMultipleInput(0)

      val emailID = firstMultipleInput(1)

      if (pattern.findFirstIn(emailID).isDefined) {
        que.enqueue(firstName)
      }
    }

    que.sorted.foreach(println(_))
  }
}
