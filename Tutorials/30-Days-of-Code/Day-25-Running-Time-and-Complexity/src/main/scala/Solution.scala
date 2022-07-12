import scala.io.StdIn

object Solution {

  def isPrime(n: Long): Boolean = {
    if (n == 2) {
      return true
    }
    if (n == 1 || n % 2 == 0) {
      return false
    }

    var i = 3
    while (i * i <= n) {
      if (n % i == 0) {
        return false
      }
      i += 2
    }

    true
  }

  def checkPrime(a: Array[Long]): Array[String] = {
    a.map(x => if (isPrime(x)) {
      "Prime"
    } else {
      "Not prime"
    })
  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val n = StdIn.readLine.trim.toInt

    val a = Array.ofDim[Long](n)

    for (i <- 0 until n) {
      a(i) = StdIn.readLine.toLong
    }

    // Write your code here
    println(checkPrime(a).mkString("\n"))
  }
}
