import scala.math._

object Solution {
  def main(args: Array[String]): Unit = {
    val odd: Double = 1.toDouble / 3.toDouble
    val chance1: Double = odd
    val chance2: Double = (1 - odd) * odd
    val chance3: Double = pow(1 - odd, 2) * odd
    val chance4: Double = pow(1 - odd, 3) * odd
    val chance5: Double = pow(1 - odd, 4) * odd

    println(f"${chance1 + chance2 + chance3 + chance4 + chance5}%.3f")
  }
}
