import java.io._
import scala.collection.mutable.Map
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
    val myMap: Map[Char, Int] = Map()

    for (i <- 0 until s.length) {
      if (myMap.contains(s.charAt(i))) {
        myMap(s.charAt(i)) = myMap(s.charAt(i)) + 1
      } else {
        myMap(s.charAt(i)) = 1
      }
    }

    var str = ""

    myMap.keys.toList.sorted.foreach(x => {
      for (_ <- 0 until myMap(x) / 2) {
        str = str.concat(x.toString)
      }
    })

    str
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
