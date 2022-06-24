import java.io._
import java.util._
import scala.collection.mutable
import scala.io._

object Result {

  /*
   * Complete the 'journeyToMoon' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. 2D_INTEGER_ARRAY astronaut
   */

  def journeyToMoon(n: Int, astronaut: Array[Array[Int]]): Int = {
    // Write your code here

    println(s"Total $n sstronauts ")
    astronaut.map(x => println(x.mkString(",")))

    val graph: Map[()] = mutable.HashMap(List[Int]())()



    0
  }

}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val n = firstMultipleInput(0).toInt

    val p = firstMultipleInput(1).toInt

    val astronaut = Array.ofDim[Int](p, 2)

    for (i <- 0 until p) {
      astronaut(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    }

    val result = Result.journeyToMoon(n, astronaut)

    printWriter.println(result)

    printWriter.close()
  }
}



