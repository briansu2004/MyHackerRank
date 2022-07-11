import java.math._
import java.util._
import scala.collection.immutable._
import scala.io._
import scala.math._

object Result {
  val factorialBigInt: LazyList[BigInt] = {
    def f: LazyList[BigInt] = {
      BigInt(1) #:: f.zipWithIndex.map { n => n._1 * (n._2 + 2) }
    }

    BigInt(1) #:: f
  }

  /*
   * Complete the 'extraLongFactorials' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  def extraLongFactorials(n: Int): Unit = {
    // Write your code here
    println(factorialBigInt(n))
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt

    Result.extraLongFactorials(n)
  }
}
