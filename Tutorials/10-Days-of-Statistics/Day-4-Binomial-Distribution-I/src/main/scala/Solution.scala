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
    val total = 6
    val min = 3
    var chance: Double = 0

    (min to total).foreach(x => chance = chance + calc(x, total, boy / (boy + girl)))

    println(f"$chance%.3f")
  }
}
