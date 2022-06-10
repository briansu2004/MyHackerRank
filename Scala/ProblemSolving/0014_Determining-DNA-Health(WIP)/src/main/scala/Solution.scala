import scala.collection.immutable._
import scala.io._

object Solution {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readLine.trim.toInt
    val genes = StdIn.readLine.replaceAll("\\s+$", "").split(" ")
    val health = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
    val s = StdIn.readLine.trim.toInt

    var dna: List[List[String]] = List()
    for (sItr <- 1 to s) {
      val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

      val first = firstMultipleInput(0)

      val last = firstMultipleInput(1)

      val d = firstMultipleInput(2)

      dna = dna ::: List(List(first, last, d))
    }

    DeterminingDNAHealth(genes, health, dna.map(_.toArray).toArray)
  }

  def DeterminingDNAHealth(genes: Array[String], health: Array[Int], dna: Array[Array[String]])
  : Unit = {
//    println(s"genes: ${genes.mkString(" ")}")
//    println(s"health: ${health.mkString(" ")}")
//    println(s"dna: ${dna.map(_.mkString).mkString("\n")}")

    var unhealthiest: Long = Long.MaxValue
    var healthiest: Long = Long.MinValue

    for (i <- dna.indices) {
      val first: Int = dna(i)(0).toInt
      val last: Int = dna(i)(1).toInt
      val d = dna(i)(2)
      val validGenes: Array[String] = genes.slice(first, last + 1)
      var score: Long = 0L
      for (j <- d.indices) {
        for (m <- validGenes.indices) {
          if (j + validGenes(m).length <= d.length && d.slice(j, validGenes(m).length + j) == validGenes(m)) {
            score = score + health(m + first)
          }
        }
      }
      if (unhealthiest > 0L) {
        unhealthiest = math.min(unhealthiest, score)
      }
      healthiest = math.max(healthiest, score)
    }

    println(s"$unhealthiest $healthiest")
  }
}
