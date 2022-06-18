import java.io._
import scala.io._

object Result {
  def getMeanMedianMode(arr: Array[BigInt]): Array[BigDecimal] = {
    val len = arr.length
    val mean = BigDecimal(arr.sum) / len
    var median: BigDecimal = 0
    //val sortedArr: Array[BigInt] = arr.sortBy(_)(Ordering[BigInt])
    val sortedArr: Array[BigInt] = arr.sorted
    if (len % 2 == 1) {
      median = BigDecimal(sortedArr((len + 1) / 2))
    } else {
      median = (BigDecimal(sortedArr(len / 2 - 1)) + BigDecimal(sortedArr(len / 2))) / 2
    }

    val mode: BigDecimal = 0

    var modeArr: Array[BigInt] = Array.fill(0)(arr.max + 1)
    for (i <- arr.indices) {
      //modeArr(arr(i)) = modeArr(arr(i)) + 1
      println(arr(i))
    }

    Array(mean, median, mode)
  }
}

object Solution {

  def main(args: Array[String]) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val printWriter = new PrintWriter(System.out);
    val count = StdIn.readLine.trim.toInt
    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim).map(BigInt(_))

    val res = Result.getMeanMedianMode(arr)
    printWriter.println(res.mkString("\n"))
    printWriter.close()
  }
}

//object Solution {
//  def main(args: Array[String]) {
//    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))
//
//    val arrCount = StdIn.readLine.trim.toInt
//
//    val arr = StdIn.readLine.replaceAll("\\s+$", "").split(" ").map(_.trim.toInt)
//
//    val res = Result.reverseArray(arr)
//
//    printWriter.println(res.mkString(" "))
//
//    printWriter.close()
//  }
//}
