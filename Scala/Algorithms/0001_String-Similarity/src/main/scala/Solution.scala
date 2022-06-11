import java.io._
import scala.io._

object Result {
  /*
   * Complete the 'stringSimilarity' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  def stringSimilarity(s: String): BigInt = {
    // Write your code here
    var n = BigInt(s.length)

    val Z: Array[BigInt] = Array.ofDim[BigInt](s.length)
    getZarr(s, s.length, Z)
//    Z(0) = s.length
//    println(s"The Z array of $s is: ${Z.mkString(",")}")

    for (i <- 1 until s.length) {
      n = n + Z(i)
    }

    n
  }

  def getZarr(s: String, n: Int, Z: Array[BigInt]): Unit = {
    /// [L,R] make a window which matches with prefix of s
    var L = 0
    var R = 0

    for (i <- 1 until n) {
      // if i>R nothing matches so we will calculate Z[i] using naive way.
      if (i > R) {
        L = i
        R = i

        // R-L = 0 in starting, so it will start checking from 0'th index.
        // e.g. for "ababab" and i = 1, the value of R remains 0 and Z[i] becomes 0.
        //  For string "aaaaaa" and i = 1, Z[i] and R become 5.
        while (R < n && s.charAt(R - L) == s.charAt(R)) {
          R = R + 1
        }

        Z(i) = R - L
        R = R - 1
      } else {
        // k = i-L so k corresponds to number which matches in [L,R] interval.
        val k = i - L

        // if Z[k] is less than remaining interval, then Z[i] will be equal to Z[k].
        // e.g. str = "ababab", i = 3, R = 5 and L = 2
        if (Z(k) < R - i + 1) {
          Z(i) = Z(k)
        }
        // For example str = "aaaaaa" and i = 2, R is 5, L is 0
        else {
          // else start from R and check manually
          L = i
          while (R < n && s.charAt(R - L) == s.charAt(R)) {
            R = R + 1
          }
          Z(i) = R - L
          R = R - 1
        }
      }
    }
  }

//  def stringSimilarityInt(s: String): Int = {
//    // Write your code here
//    var n = s.length
//
//    //val Z: Array[Int] = Array.fill[Int](s.length)(0)
//    val Z: Array[Int] = Array.ofDim[Int](s.length)
//    getZarrInt(s, s.length, Z)
//
//    for (i <- 1 until s.length) {
//      n = n + Z(i)
//    }
//
//    n
//  }
//
//  def getZarrInt(s: String, n: Int, Z: Array[Int]): Unit = {
//    /// [L,R] make a window which matches with prefix of s
//    var L = 0
//    var R = 0
//
//    for (i <- 1 until n) {
//      // if i>R nothing matches so we will calculate Z[i] using naive way.
//      if (i > R) {
//        L = i
//        R = i
//
//        // R-L = 0 in starting, so it will start checking from 0'th index.
//        // e.g. for "ababab" and i = 1, the value of R remains 0 and Z[i] becomes 0.
//        //  For string "aaaaaa" and i = 1, Z[i] and R become 5.
//        while (R < n && s.charAt(R - L) == s.charAt(R)) {
//          R = R + 1
//        }
//
//        Z(i) = R - L
//        R = R - 1
//      } else {
//        // k = i-L so k corresponds to number which matches in [L,R] interval.
//        val k = i - L
//
//        // if Z[k] is less than remaining interval, then Z[i] will be equal to Z[k].
//        // e.g. str = "ababab", i = 3, R = 5 and L = 2
//        if (Z(k) < R - i + 1) {
//          Z(i) = Z(k)
//        }
//        // For example str = "aaaaaa" and i = 2, R is 5, L is 0
//        else {
//          // else start from R and check manually
//          L = i
//          while (R < n && s.charAt(R - L) == s.charAt(R)) {
//            R = R + 1
//          }
//          Z(i) = R - L
//          R = R - 1
//        }
//      }
//    }
//  }

  //  def stringSimilarityN2(s: String): Int = {
  //    // Write your code here
  //    var n = s.length
  //    for (i <- 1 until s.length) {
  //      val ns = s.slice(i, s.length)
  //      n = n + getStringSimilarityN2(s, ns)
  //    }
  //    n
  //  }
  //
  //  def getStringSimilarityN2(s: String, ns: String): Int = {
  //    var n = 0
  //    breakable {
  //      for (i <- 0 until ns.length) {
  //        if (s.slice(i, i + 1) == ns.slice(i, i + 1)) {
  //          n = n + 1
  //        } else {
  //          break
  //        }
  //      }
  //    }
  //    n
  //  }

}

object Solution {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val t = StdIn.readLine.trim.toInt

    for (_ <- 1 to t) {
      val s = StdIn.readLine

      val result = Result.stringSimilarity(s)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
