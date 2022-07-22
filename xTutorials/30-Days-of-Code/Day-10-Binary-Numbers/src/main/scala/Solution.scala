import java.util._
import scala.io._

object Result {
  def getBinaryNumbers(num: Int): Int = {
    val parts = num.toBinaryString.split("0")
    var n = 0
    for (i <- 0 until parts.length) {
     if (n < parts(i).length) {
       n = parts(i).length
     }
    }
    n
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt
    val res = Result.getBinaryNumbers(n)
    println(res)
  }
}
