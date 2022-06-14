import scala.io._

object Solution {
  def main(args: Array[String]) {
    val Array(roadNodes, roadEdges) = StdIn.readLine().replaceAll("\\s+$", "").split(" ").map(_.toInt)

    val roadFrom = Array.ofDim[Int](roadEdges)
    val roadTo = Array.ofDim[Int](roadEdges)
    val roadWeight = Array.ofDim[Int](roadEdges)

    for (i <- 0 until roadEdges) {
      val roadFromToWeight = StdIn.readLine().replaceAll("\\s+$", "").split(" ")

      roadFrom(i) = roadFromToWeight(0).toInt
      roadTo(i) = roadFromToWeight(1).toInt
      roadWeight(i) = roadFromToWeight(2).toInt
    }

    val q = StdIn.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val x = firstMultipleInput(0).toInt

      val y = firstMultipleInput(1).toInt
    }
  }
}

