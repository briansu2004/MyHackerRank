import java.io._
import scala.io._

object Result_good1 {
  /*
   * Complete the 'countGroups' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING_ARRAY related as parameter.
   */

  // example
  // related: ['1100', '1110', '0110', '0110', '0001']
  // result: 2
  def countGroups(related: Array[String]): Int = {
    // Write your code here

    // 1. Get the size n
    // 2. add 0 to a new Set
    //    init g is n
    // 3. loop
    //    i from 1 to n-1
    //    j from 0 -> i-1
    //    if t[i][j] is 1,
    //    remove j from j's Set
    //    then add j to i's Set
    // 5. Count all the non-empty Sets

    val pplCount = related(0).length
    println(s"Total people: $pplCount")

    var groups : Array[List[BigInt]] = new Array[List[BigInt]](pplCount)
    for (i <- 0 until pplCount) {
      // add i as a new list element in the group list
      groups(i) = List(i)
    }
//    println(s"Initialize the groups as:")
//    groups.foreach(x => println(x))

    for (i <- 1 until pplCount) {
      for (j <- 0 until i) {
        println(s"$i $j: ${related(i)(j)}")
        if (related(i)(j) == '1') {
          println(s"$i and $j is related, adding $j to the $i's group")
          if (groups(i).length > 0) {
            groups(i) = j :: groups(i)
          } else {
            // if i is not in groups(i) then find it first
            for (n <- 0 until pplCount) {
              if (groups(n).contains(i)) {
                groups(n) = j :: groups(n)
              }
            }
          }
          println(s"then remove $j from its original group")
          groups(j) = List()
        }
      }
    }

    println(s"After the relation analysis, the groups are:")
    groups.foreach(x => println(x))

    var groupCount = 0
    groups.foreach(x => if (x.length > 0) groupCount = groupCount + 1)
    println(s"There are $groupCount groups total.")
    groupCount
  }
}

object Solution_good1 {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val relatedCount = StdIn.readLine.trim.toInt

    val related = Array.ofDim[String](relatedCount)

    for (i <- 0 until relatedCount) {
      val relatedItem = StdIn.readLine
      related(i) = relatedItem
    }

    val result = Result.countGroups(related)

    printWriter.println(result)

    printWriter.close()
  }
}
