import scala.io.StdIn

object Solution {
  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
    val n = 5
    val XY: Array[Array[Int]] = Array.ofDim(n)
    for (i <- 0 until n) {
      XY(i) = StdIn.readLine.trim().split(" ").map(xy => xy.toInt)
    }

    var sx, sy, sx2, sxy = 0
    XY.foreach(xy => {
      sx += xy(0)
      sy += xy(1)
      sx2 += xy(0) * xy(0)
      sxy += xy(0) * xy(1)
    })

    val b: Double = (n * sxy - sx * sy).toDouble / (n * sx2 - sx * sx).toDouble
    val a: Double = (sy.toDouble / n) - b * (sx.toDouble / n)

    println(f"${a + b * 80}%.3f")
  }
}
