import scala.collection.mutable
import scala.io.StdIn

object Solution {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val mn: Array[Int] = StdIn.readLine.trim().split(" ").map(xy => xy.toInt)
    val m = mn(0)
    val n = mn(1)

    var X: mutable.Queue[List[Float]] = mutable.Queue[List[Float]]()
    var Y: mutable.Queue[List[Float]] = mutable.Queue[List[Float]]()
    for (i <- 0 until n) {
      val data: List[Float] = StdIn.readLine.trim().split(" ").map(d => d.toFloat).toList
      X.enqueue(data.slice(0, m))
      Y.enqueue(data.slice(m, data.length))
    }

    val q = StdIn.readLine.trim().toInt
    val X_new: mutable.Queue[List[Float]] = mutable.Queue[List[Float]]()
    for (i <- 0 until q) {
      X_new.enqueue(StdIn.readLine.trim().split(" ").map(d => d.toFloat).toList)
    }





    println("Done")
  }
}
