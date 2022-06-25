import scala.io.StdIn
import scala.math._

object Solution {
  def get_rank(X: List[Double]): List[Int] = {
    val listX = X.toSet.toList.sorted

    var mapX: Map[Double, Int] = Map()
    for ((x, count) <- listX.zip(LazyList from 1)) {
      mapX += (x -> count)
    }

    X.map { x => mapX(x) }
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
    val n = StdIn.readLine.toInt
    val X: List[Double] = StdIn.readLine.trim().split(" ").toList.map(x => x.toDouble)
    val Y: List[Double] = StdIn.readLine.trim().split(" ").toList.map(x => x.toDouble)

    val rx = get_rank(X)
    val ry = get_rank(Y)

    var d: Double = 0
    for (i <- 0 until n) {
      d = d + pow(rx(i) - ry(i), 2)
    }
    val rxy = 1 - (6 * d) / (n * (n * n - 1))

    println(f"$rxy%.3f")
  }
}
