import java.io._
import java.math._
import java.util._
import scala.io._

object Result {

  /*
   * Complete the 'permutationEquation' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY p as parameter.
   */

  def permutationEquation(p: Array[Int]): Array[Int] = {
    // Write your code here
    var res: Array[Int] = p

//    for ((x, xIdx) <- p.zipWithIndex) {
//      // x: 5, p(1): 5 => p(3): 1 => p(p(3)) = 5 => 3 -> 5
//      // Step 1: get x and xIdx (1 5)
//      // Step 2: find yIdx for xIdx (3)
//      // Step 3: res[yIdx] = x
//
//      // Step 1: get x and xIdx (1 3)
//      // Step 2: find yIdx for xIdx (2)
//      // Step 3: res[yIdx] = x
//      val yIdx = p.indexOf(xIdx + 1) + 1
//
//      println(s"${xIdx + 1}: $x\t$yIdx")
//      res(yIdx) = x
//    }

    for (i <- p.indices) {
      val x = i + 1
      val xIdx = p.indexOf(x) + 1
      var yIdx = p.indexOf(xIdx)
//      if (yIdx == p.length) {
//        yIdx = 0
//      }

//      if (yIdx > 0 && yIdx < p.length) {
//        res(yIdx - 1) = x
//      }
      println(s"$x ${xIdx + 1} $yIdx -> res($yIdx) = $x")
      res(yIdx) = x
    }

    res
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val p = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)

    val result = Result.permutationEquation(p)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
