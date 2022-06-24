import scala.collection.mutable._

object Solution {
  /* Using Queue ! */
  def parseString(s: String): String = {
    var odd = Queue[Char]()
    var even = Queue[Char]()

    for (i <- 0 until s.length by 2) {
      even.enqueue(s(i))
      if (i < s.length - 1) {
        odd.enqueue(s(i + 1))
      }
    }

    even.mkString("") + " " + odd.mkString("")
  }

// /* Not good as well */
//  def parseString2(s: String): String = {
//    val odd: Array[Char] = Array.ofDim[Char](s.length)
//    val even: Array[Char] = Array.ofDim[Char](s.length)
//
//    for (i <- 0 until s.length by 2) {
//      even(i) = s(i)
//      if (i < s.length - 1) {
//        odd(i + 1) = s(i + 1)
//      }
//    }
//
//    even.filter(_.isLetter).mkString("") + " " + odd.filter(_.isLetter).mkString("")
//  }

// /* Not good */
//  def parseString1(s: String): String = {
//    var odd: List[Char] = List()
//    var even: List[Char] = List()
//
//    s.zipWithIndex foreach {
//      case (c, index) =>
//        if (index % 2 == 1) {
//          odd = odd ::: c :: Nil
//        } else {
//          even = even ::: c :: Nil
//        }
//    }
//
//    even.mkString("") + " " + odd.mkString("")
//  }

  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val T = scala.io.StdIn.readInt()
    for (_ <- 1 to T) {
      val str = scala.io.StdIn.readLine()
      println(parseString(str))
    }
  }
}


