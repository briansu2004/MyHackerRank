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
  def cdf(mean: Double, std: Double, x: Double): Double = {
    0.5 * (1 + erf((x - mean) / (std * pow(2, 0.5))))
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val mean_std = StdIn.readLine.trim.split(" ")
    val mean = mean_std(0).toDouble
    val std = mean_std(1).toDouble

    val n1 = StdIn.readLine.trim.toDouble
    val n2 = StdIn.readLine.trim.toDouble

    val p1 = (1 - cdf(mean, std, n1)) * 100
    val p2 = (1 - cdf(mean, std, n2)) * 100
    val p3 = cdf(mean, std, n2) * 100

    println(f"$p1%.2f")
    println(f"$p2%.2f")
    println(f"$p3%.2f")
  }
}
