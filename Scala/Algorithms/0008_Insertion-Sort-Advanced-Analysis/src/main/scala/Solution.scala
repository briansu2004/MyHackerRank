import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'insertionSort' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  def merge(arr: Array[BigInt], left: Array[BigInt], right: Array[BigInt]): BigInt = {
    var cnt: BigInt = 0

    var i = 0
    var iLeft = 0
    var iRight = 0
    val leftLen = left.length
    val rightLen = right.length

    while (iLeft < leftLen && iRight < rightLen) {
      if (left(iLeft) <= right(iRight)) {
        arr(i) = left(iLeft)
        iLeft = iLeft + 1
      } else {
        arr(i) = right(iRight)
        iRight = iRight + 1
        cnt = cnt + leftLen - iLeft
      }
      i = i + 1
    }
    while (iLeft < leftLen) {
      arr(i) = left(iLeft)
      iLeft = iLeft + 1
      i = i + 1
    }
    while (iRight < rightLen) {
      arr(i) = right(iRight)
      iRight = iRight + 1
      i = i + 1
    }

    cnt
  }

  def mergeSort(arr: Array[BigInt]): BigInt = {
    var n: BigInt = 0

    val mid = (arr.length - arr.length % 2) / 2

    if (mid > 0) {
      val leftArr: Array[BigInt] = arr.slice(0, mid)
      val rightArr: Array[BigInt] = arr.slice(mid, arr.length)
      n = n + mergeSort(leftArr)
      n = n + mergeSort(rightArr)
      n = n + merge(arr, leftArr, rightArr)
    }

    n
  }

  def insertionSort(arr: Array[BigInt]): BigInt = {
    // Write your code here
    mergeSort(arr)
  }

//  def insertionSort_Slow(arr: Array[Int]): Int = {
//    // Write your code here
//    var n = 0
//
//    //println(s"Before the insert sorting: ${arr.mkString(",")}")
//    for (i <- 1 until arr.length) {
//      for (j <- i to 1 by -1)
//        if (arr(j - 1) > arr(j)) {
//          //println(s"Swap ${j-1} and $j")
//          swap(arr, j - 1, j)
//          n = n + 1
//        }
//    }
//    //println(s"After the insert sorting: ${arr.mkString(",")}")
//
//    n
//  }
//
//  def swap(arr: Array[Int], x: Int, y: Int): Unit = {
//    val t = arr(x)
//    arr(x) = arr(y)
//    arr(y) = t
//  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (tItr <- 1 to t) {
      val n = StdIn.readLine.trim.toInt

      val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim).map(BigInt(_))
      val result = Result.insertionSort(arr)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
