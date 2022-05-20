import java.io._
import scala.collection.immutable._
import scala.io._

object Result {

  /*
   * Complete the 'viralAdvertising' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER n as parameter.
   */

  //  val fibLazy: LazyList[BigInt] = {
  //    def fs(prev: BigInt, curr: BigInt): LazyList[BigInt] = prev #:: fs(curr, prev + curr)
  //    fs(0, 1)
  //  }
  val vaLazy: LazyList[Int] = {
    // def va(prev: Int, curr: Int): LazyList[Int] = prev #:: va(curr, (curr + ((curr - prev) * 3 / 2).floor).toInt)
    def va(prev: Int, curr: Int): LazyList[Int] = prev #:: va(curr, (curr + ((curr - prev) * 3 - (curr - prev) * 3 %
      2) / 2))

    va(0, 2)
  }

  def viralAdvertising(n: Int): Int = {
    // Write your code here
    vaLazy(n)
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out) //sys.env("OUTPUT_PATH"))

    val n = StdIn.readLine.trim.toInt

    val result = Result.viralAdvertising(n)

    printWriter.println(result)

    printWriter.close()
  }
}
