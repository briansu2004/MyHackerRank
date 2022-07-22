import java.math._
import java.util._
import scala.io._
import scala.util.control.Breaks


object Solution {
  def doBubbleSort(ar: Array[Int]): Unit = {
    var cnt = 0

    val loop = new Breaks
    loop.breakable {
      for (_ <- ar.indices) {
        var num = 0

        for (j <- 0 until ar.length - 1) {
          if (ar(j) > ar(j + 1)) {
            val t = ar(j)
            ar(j) = ar(j + 1)
            ar(j + 1) = t
            num += 1
          }
        }

        //println(s"round ${i + 1}  ar: ${ar.mkString(" ")} swap this round: $num")
        cnt += num
        if (num == 0) {
          loop.break
        }
      }
    }

    println(s"Array is sorted in $cnt swaps.")
    println(s"First Element: ${ar(0)}")
    println(s"Last Element: ${ar(ar.length - 1)}")
  }

  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    val a = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    // Write your code here
    doBubbleSort(a)
  }
}
