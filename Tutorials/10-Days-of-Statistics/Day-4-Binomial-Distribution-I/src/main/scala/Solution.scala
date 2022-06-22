import scala.annotation.tailrec
import scala.math._

object Solution {

  @tailrec
    def fact(n: Int): Int = {
      if (n == 0) {
        return 1
      }

      n * fact(n - 1)
    }

  def main(args: Array[String]) {
    val boy = 1.09
    val girl = 1
    val chance = pow(boy / (boy + girl), 3) * (1 + 1 / (boy + girl) + 1 / (boy + girl) * (boy + girl) + 1 / (boy + girl) * (boy + girl) * (boy + girl))
    println(f"$chance%.3f")
  }
}
