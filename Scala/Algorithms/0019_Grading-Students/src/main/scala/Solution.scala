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
   * Complete the 'gradingStudents' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY grades as parameter.
   */
  def gradingStudents1(grades: Array[Int]): Array[Int] = {
    // Write your code here
    var result = grades.clone()

    for (i <- result.indices) {
      val n = result(i)
      if (n > 40 && n % 5 > 2) {
        result(i) = ((n - (n % 5)) / 5 + 1).toInt * 5
      }
    }

    result
  }

  def gradingStudents(grades: Array[Int]): Array[Int] = {
    // Write your code here
    for (i <- grades.indices) {
      val n = grades(i)
      if (n > 37 && n % 5 > 2) {
        grades(i) = ((n - (n % 5)) / 5 + 1).toInt * 5
      }
    }

    grades
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val gradesCount = StdIn.readLine.trim.toInt

    val grades = Array.ofDim[Int](gradesCount)

    for (i <- 0 until gradesCount) {
      val gradesItem = StdIn.readLine.trim.toInt
      grades(i) = gradesItem
    }

    val result = Result.gradingStudents(grades)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}
