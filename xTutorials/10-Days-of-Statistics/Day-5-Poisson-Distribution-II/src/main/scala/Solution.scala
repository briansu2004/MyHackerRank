object Solution {

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val a = scala.io.StdIn.readLine().split(" ")
    val averageX = a(0).toDouble
    val averageY = a(1).toDouble

    val costX = 160 + 40 * (averageX + averageX * averageX)
    val costY = 128 + 40 * (averageY + averageY * averageY)

    println(f"$costX%.3f")
    println(f"$costY%.3f")
  }
}
