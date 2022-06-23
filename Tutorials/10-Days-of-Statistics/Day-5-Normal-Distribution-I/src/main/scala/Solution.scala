object Solution {
  val factorial: LazyList[Int] = {
    def f: LazyList[Int] = {
      1.toInt #:: f.zipWithIndex.map { n => n._1 * (n._2 + 2) }
    }
    1 #:: f
  }

  def getProbability(mean: Double, n: Int): Double = {
    scala.math.pow(mean, n) * scala.math.exp(-mean) / factorial(n)
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val mean = scala.io.StdIn.readDouble()
    val n = scala.io.StdIn.readInt()
    println(f"${getProbability(mean, n)}%.3f")
  }
}
