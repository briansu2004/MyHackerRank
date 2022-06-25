import scala.collection.mutable

object Solution {
  def main(args: Array[String]): Unit = {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution
*/
    val mapPhoneBook: mutable.Map[String, String] = mutable.Map()
    val T = scala.io.StdIn.readInt()
    for (_ <- 1 to T) {
      val record = scala.io.StdIn.readLine().split(" ")
      mapPhoneBook += record(0) -> record(1)
    }

    var line = scala.io.StdIn.readLine()
    while (line != null && line != "") {
      if (mapPhoneBook.contains(line)) {
        println(line + "=" + mapPhoneBook(line))
      } else {
        println("Not found")
      }
      line = scala.io.StdIn.readLine()
    }
  }
}


