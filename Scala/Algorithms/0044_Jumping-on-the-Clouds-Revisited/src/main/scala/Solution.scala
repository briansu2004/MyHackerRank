import java.io._
import java.math._
import java.util._

object Solution {

  // Complete the jumpingOnClouds function below.
  def jumpingOnClouds(c: Array[Int], k: Int): Int = {
    var energy = 100
    var pos = k % c.length

    while (pos != 0) {
      if (c(pos) == 1) {
        energy -= 3
      } else {
        energy -= 1
      }
      pos = (pos + k) % c.length
    }

    if (c(0) == 1) {
      energy - 3
    } else {
      energy - 1
    }
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(System.out)

    val nk = stdin.readLine.split(" ")

    val n = nk(0).trim.toInt

    val k = nk(1).trim.toInt

    val c = stdin.readLine.split(" ").map(_.trim.toInt)
    val result = jumpingOnClouds(c, k)

    printWriter.println(result)

    printWriter.close()
  }
}
