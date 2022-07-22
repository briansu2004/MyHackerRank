import scala.math._

object Solution {
  val factorials: LazyList[Int] = {
    def f: LazyList[Int] = {
      1 #:: f.zipWithIndex.map { n => n._1 * (n._2 + 2) }
    }

    1 #:: f
  }

  def comb(n: Int, x: Int): Double = {
    factorials(n).toDouble / (factorials(x).toDouble * factorials(n - x).toDouble)
  }

  def calc(x: Int, n: Int, p: Double): Double = {
    comb(n, x) * pow(p, x) * pow(1 - p, n - x)
  }

  def main(args: Array[String]): Unit = {
    val rate = 0.12
    val total = 10
    var chance1: Double = 0
    var chance2: Double = 0

    (0 to 2).foreach(x => chance1 = chance1 + calc(x, total, rate))
    println(f"$chance1%.3f")

    (2 to total).foreach(x => chance2 = chance2 + calc(x, total, rate))
    println(f"$chance2%.3f")
  }
}
