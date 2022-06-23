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
    val boy = 1.09
    val girl = 1
    var odds: Double = 0
    (3 to 6).foreach(x => odds = odds + calc(x, 6, boy / (boy + girl)))
    println(f"$odds%.3f")
  }
}
