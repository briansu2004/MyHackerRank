import java.math._
import java.util._
import java.util.concurrent._
import scala.io._

object Result {

  /*
   * Complete the 'insertionSort1' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  def insertionSort1(n: Int, arr: Array[Int]): Unit = {
    // Write your code here
    val m = arr(n - 1)
    val ar = arr.clone()
    var isDone = false
    var i = n - 2

    while (!isDone && i >= 0) {
      if (ar(i) > m) {
        ar(i + 1) = ar(i)
      } else {
        isDone = true
        ar(i + 1) = m
      }
      //println(s"$i: ${ar.mkString(" ")}")
      println(ar.mkString(" "))
      i -= 1
    }
    if (!isDone) {
      ar(0) = m
      println(ar.mkString(" "))
    }
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    Result.insertionSort1(n, arr)
  }
}
