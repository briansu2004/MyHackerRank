import scala.math._

object Solution {
  def main(args: Array[String]): Unit = {
    val odd: Double = 1.toDouble / 3.toDouble
    val chance: Double = pow(1 - odd, 4) * odd

    println(f"$chance%.3f")
  }
}
