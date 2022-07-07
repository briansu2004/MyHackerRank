import java.io._
import java.math._
import java.util._

object Solution {

  // Complete the catAndMouse function below.
  def catAndMouse(x: Int, y: Int, z: Int): String = {
    if (Math.abs(x - z) < Math.abs(y - z)) {
      "Cat A"
    } else if (Math.abs(x - z) > Math.abs(y - z)) {
      "Cat B"
    } else {
      "Mouse C"
    }
  }

  def main(args: Array[String]): Unit = {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(System.out)

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val xyz = stdin.readLine.split(" ")

      val x = xyz(0).trim.toInt

      val y = xyz(1).trim.toInt

      val z = xyz(2).trim.toInt

      val result = catAndMouse(x, y, z)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
