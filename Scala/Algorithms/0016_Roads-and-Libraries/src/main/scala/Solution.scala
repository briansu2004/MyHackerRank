import java.io._
import scala.collection.mutable
import scala.io._

object Result {

  /*
   * Complete the 'roadsAndLibraries' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER c_lib
   *  3. INTEGER c_road
   *  4. 2D_INTEGER_ARRAY cities
   */

  def roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: Array[Array[Int]]): Long = {
    // create graph
    val graph: Array[mutable.Queue[Int]] = Array.fill[mutable.Queue[Int]](n + 1)(mutable.Queue[Int]())
    for (i <- cities.indices) {
      // bidirectional graph
      val x = cities(i)(0)
      val y = cities(i)(1)
      graph(x).enqueue(y)
      graph(y).enqueue(x)
    }

    val visited: Array[Boolean] = Array.fill[Boolean](n + 1)(false)

    // create depth first search function to find the subset of cities
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

    // main logic
    var total_cost: Long = 0
    for (v <- 1 until n + 1) {
      if (!visited(v)) {
        // find no. of cities in the subset of graph
        val n_cities = dfs(v, graph, visited)
        // calculate cost of roads and 1 library
        val cost1 = (n_cities - 1) * c_road + c_lib
        // calculate cost of building libraries in all cities
        val cost2 = n_cities * c_lib
        // add the minimum cost to the total
        total_cost += Math.min(cost1, cost2)
      }
    }
    total_cost
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val n = firstMultipleInput(0).toInt

      val m = firstMultipleInput(1).toInt

      val c_lib = firstMultipleInput(2).toInt

      val c_road = firstMultipleInput(3).toInt

      val cities = Array.ofDim[Int](m, 2)

      for (i <- 0 until m) {
        cities(i) = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
      }

      val result = Result.roadsAndLibraries(n, c_lib, c_road, cities)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
