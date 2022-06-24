import java.io._
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

  def cn2(n: Long): Long = {
    n * (n - 1) / 2
  }

  def journeyToMoon(n: Int, astronaut: Array[Array[Int]]): Long = {
    // Write your code here
    //    println(s"Total $n sstronauts ")
    //    astronaut.map(x => println(x.mkString(",")))

    //val graph: Array[Array[Int]] = Array.ofDim[Int](n, n)
    val graph: Array[mutable.Queue[Int]] = Array.fill[mutable.Queue[Int]](n)(mutable.Queue[Int]())
    for (i <- astronaut.indices) {
      val x = astronaut(i)(0)
      val y = astronaut(i)(1)
      graph(x).enqueue(y)
      graph(y).enqueue(x)
    }

    val visited: Array[Boolean] = Array.fill[Boolean](n)(false)

    var pairs: Long = cn2(n)

    def dfs(u: Int, graph: Array[mutable.Queue[Int]], visited: Array[Boolean]): Int = {
      visited(u) = true

      var vertices = 1
      for (v <- graph(u).indices) {
        if (!visited(graph(u)(v))) {
          vertices = vertices + dfs(graph(u)(v), graph, visited)
        }
      }

      vertices
    }

    for (v <- 0 until n) {
      if (!visited(v)) {
        val numPersons = dfs(v, graph, visited)
        pairs = pairs - cn2(numPersons)
      }
    }

    pairs
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
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



