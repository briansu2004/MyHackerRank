import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.collection.concurrent._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.sys._
import scala.util.matching._
import scala.reflect._



object Result {

  /*
   * Complete the 'getMinCost' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY crew_id
   *  2. INTEGER_ARRAY job_id
   */

  def getMinCost(crew_id: Array[Int], job_id: Array[Int]): Long = {
    // Write your code here
    var min = Long.MaxValue

    val it = crew_id.permutations
    while (it.hasNext) {
      var cost = 0L
      val c = it.next()
      for (j <- job_id.indices) {
        cost += Math.abs(c(j) - job_id(j))
      }
      min = Math.min(min, cost)
    }

    min
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val crew_idCount = StdIn.readLine.trim.toInt

    val crew_id = Array.ofDim[Int](crew_idCount)

    for (i <- 0 until crew_idCount) {
      val crew_idItem = StdIn.readLine.trim.toInt
      crew_id(i) = crew_idItem
    }

    val job_idCount = StdIn.readLine.trim.toInt

    val job_id = Array.ofDim[Int](job_idCount)

    for (i <- 0 until job_idCount) {
      val job_idItem = StdIn.readLine.trim.toInt
      job_id(i) = job_idItem
    }

    val result = Result.getMinCost(crew_id, job_id)

    printWriter.println(result)

    printWriter.close()
  }
}
