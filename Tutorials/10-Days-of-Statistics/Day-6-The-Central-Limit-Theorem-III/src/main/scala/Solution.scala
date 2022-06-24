import scala.io._
import scala.math._

object Solution {
  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution */
    val samples = StdIn.readLine.trim.toDouble
    val mean = StdIn.readLine.trim.toDouble
    val sd = StdIn.readLine.trim.toDouble
    val interval = StdIn.readLine.trim.toDouble
    val z = StdIn.readLine.trim.toDouble

    val sd_sample = sd / sqrt(samples)

    println(f"${mean - sd_sample * z}%.2f")
    println(f"${mean + sd_sample * z}%.2f")
  }
}
