import scala.io._
import scala.math._

class Erf {
  // constants
  val a1: Double = 0.254829592
  val a2: Double = -0.284496736
  val a3: Double = 1.421413741
  val a4: Double = -1.453152027
  val a5: Double = 1.061405429
  val p: Double = 0.3275911

  def erf(x: Double): Double = {
    // Save the sign of x
    val sign = if (x < 0) -1 else 1
    val absx = math.abs(x)

    // A&S formula 7.1.26, rational approximation of error function
    val t = 1.0 / (1.0 + p * absx)
    val y = 1.0 - (((((a5 * t + a4) * t) + a3) * t + a2) * t + a1) * t * math.exp(-x * x)
    sign * y
  }
}

object Solution extends Erf {
  def cdf(x: Double, mu: Double, sigma: Double): Double = {
    val Z = (x - mu) / sigma
    0.5 * (1 + erf(Z / sqrt(2)))
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
    val x = StdIn.readLine.trim.toDouble
    val n = StdIn.readLine.trim.toDouble
    val mu = StdIn.readLine.trim.toDouble
    val sigma = StdIn.readLine.trim.toDouble

    val mu_sum = n * mu
    val sigma_sum = sqrt(n) * sigma

    val res = cdf(x, mu_sum, sigma_sum)
    println(f"$res%.4f")
  }
}
