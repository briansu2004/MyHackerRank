import scala.io.StdIn
import scala.math._

object Solution {
  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
    val N = StdIn.readLine.toInt
    val X: List[Double] = StdIn.readLine.trim().split(" ").toList.map(x => x.toDouble)
    val Y: List[Double] = StdIn.readLine.trim().split(" ").toList.map(x => x.toDouble)

    val mu_x = X.sum / N
    val mu_y = Y.sum / N

    //    val stdv_x = sqrt(X.foldLeft(0.0)(pow((_ - mu_x), 2) + pow(_ - mu_x, 2)) / N)
    //    val stdv_y = sqrt(Y.foldLeft(0.0)(pow(_ - mu_y, 2) + pow(_ - mu_y, 2)) / N)

    var stdv_x: Double = 0
    for (i <- X.indices) {
      stdv_x = stdv_x + pow(X(i) - mu_x, 2)
    }
    stdv_x = sqrt(stdv_x / N)

    var stdv_y: Double = 0
    for (i <- Y.indices) {
      stdv_y = stdv_y + pow(Y(i) - mu_y, 2)
    }
    stdv_y = sqrt(stdv_y / N)

    var covariance = 0.0
    for (i <- 0 until N) {
      covariance = covariance + (X(i) - mu_x) * (Y(i) - mu_y)
    }

    val correlation_coefficient = covariance / (N * stdv_x * stdv_y)

    println(f"$correlation_coefficient%.3f")
  }
}
