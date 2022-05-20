import java.io._
import scala.collection.mutable
import scala.io._
import scala.math._

object Result {

  /*
   * Complete the 'runningMedian' function below.
   *
   * The function is expected to return a DOUBLE_ARRAY.
   * The function accepts INTEGER_ARRAY a as parameter.
   */

  def runningMedian(a: Array[Int]): Array[Double] = {
    // Write your code here
    // maxheap
    val lowers = mutable.PriorityQueue[Int]()
    // minheap
    val highers = mutable.PriorityQueue[Int]()(Ordering[Int].reverse)

    val medians: Array[Double] = Array.ofDim[Double](a.length)
    for (i <- a.indices) {
      addNumber(a(i), lowers, highers)
      rebalance(lowers, highers)
      medians(i) = getMedian(lowers, highers)
    }
    medians
  }

  def getMedian(lowers: mutable.PriorityQueue[Int], highers: mutable.PriorityQueue[Int]): Double = {
    var biggerHeap: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()
    var smallerHeap: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()
    if (lowers.size > highers.size) {
      biggerHeap = lowers
      smallerHeap = highers
    } else {
      biggerHeap = highers
      smallerHeap = lowers
    }

    if (biggerHeap.size == smallerHeap.size) {
      (smallerHeap.head + biggerHeap.head).toDouble / 2
    } else {
      biggerHeap.head
    }
  }

  def rebalance(lowers: mutable.PriorityQueue[Int], highers: mutable.PriorityQueue[Int]): Unit = {
    var biggerHeap: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()
    var smallerHeap: mutable.PriorityQueue[Int] = mutable.PriorityQueue[Int]()
    if (lowers.size > highers.size) {
      biggerHeap = lowers
      smallerHeap = highers
    } else {
      biggerHeap = highers
      smallerHeap = lowers
    }

    if (biggerHeap.size - smallerHeap.size >= 2) {
      smallerHeap.enqueue(biggerHeap.dequeue())
    }
  }

  def addNumber(n: Int, lowers: mutable.PriorityQueue[Int], highers: mutable.PriorityQueue[Int]): Unit = {
    if (lowers.isEmpty || n < lowers.head) {
      lowers.enqueue(n)
    } else {
      highers.enqueue(n)
    }
  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val aCount = StdIn.readLine.trim.toInt

    val a = Array.ofDim[Int](aCount)

    for (i <- 0 until aCount) {
      val aItem = StdIn.readLine.trim.toInt
      a(i) = aItem
    }

    val result = Result.runningMedian(a)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
