import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._
import scala.collection.concurrent._
import scala.collection.immutable._
import scala.collection.mutable._
import scala.concurrent._
import scala.io._
import scala.math._
import scala.reflect._
import scala.sys._
import scala.util.matching._

object Result {

  /*
   * Complete the 'caesarCipher' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. INTEGER k
   */

  def caesarCipher(s: String, k: Int): String = {
    // Write your code here
    s.map(c =>
      if ((c - 'a') >= 0 && (c - 'z') <= 0) {
        ((c - 'a' + k) % 26 + 97).toChar
      } else if ((c - 'A') >= 0 && (c - 'Z') <= 0) {
        ((c - 'A' + k) % 26 + 65).toChar
      } else {
        c
      }
    )
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val n = StdIn.readLine.trim.toInt

    val s = StdIn.readLine

    val k = StdIn.readLine.trim.toInt

    val result = Result.caesarCipher(s, k)

    printWriter.println(result)

    printWriter.close()
  }
}
