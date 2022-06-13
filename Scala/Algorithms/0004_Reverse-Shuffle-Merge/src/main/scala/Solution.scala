import java.io._
import scala.io._

object Result {

  /*
   * Complete the 'reverseShuffleMerge' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  def reverseShuffleMerge(s: String): String = {
    // Write your code here

    // fill the arrays
    val n = s.length
    var j = 0
    val res = Array.ofDim[Char](100000)
    val unused = Array.fill[Int](26)(0)
    val used = Array.fill[Int](26)(0)
    val required = Array.fill[Int](26)(0)

    s.foreach(x => unused(x - 'a') = unused(x - 'a') + 1)
    for (i <- unused.indices) {
      required(i) = unused(i) / 2
    }
//    println(s"unused: ${unused.mkString("")}")
//    println(s"used: ${used.mkString("")}")
//    println(s"required: ${required.mkString("")}")

    // last character
    var c = s(n - 1)
    var cPos = c - 'a'
    res(j) = c
    j = j + 1
    unused(cPos) = unused(cPos) - 1
    used(cPos) = used(cPos) + 1

    // the rest of characters
    // adding with the conditions:
    //       required limit not be met yet
    //       smaller than the previous (also need to remove previous bigger characters)
    for (i <- n - 2 to 0 by -1) {
      c = s(i)
      cPos = c - 'a'
      // to add or not
      if (used(cPos) < required(cPos)) {
        // add char
        if (c > res(j - 1)) {
          res(j) = c
          j = j + 1
          unused(cPos) = unused(cPos) - 1
          used(cPos) = used(cPos) + 1
        } else {
          // check bigger element
          while (j > 0 && c < res(j - 1) && used(res(j - 1) - 'a') - 1 + unused(res(j - 1) - 'a') >= required(res(j - 1) - 'a')) {
            j = j - 1
            used(res(j) - 'a') = used(res(j) - 'a') - 1
          }
          res(j) = c
          j = j + 1
          unused(cPos) = unused(cPos) - 1
          used(cPos) = used(cPos) + 1
        }
      } else {
        // discarding
        unused(cPos) = unused(cPos) - 1
      }
    }

    res.slice(0, n / 2).mkString("")
  }
}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val s = StdIn.readLine

    val result = Result.reverseShuffleMerge(s)

    printWriter.println(result)

    printWriter.close()
  }
}
