import java.io._
import scala.io._
import scala.util.control.Breaks.{break, breakable}

object Result_fail2 {
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
    // 2. (skip this) Check the diagonal
    //    loop
    //    i from 1 to n-1
    //    if (i-1)(i) and (i)(i-1) and (i+1)(i) and (i)(i+1) is 1,
    //    then make (i-1)(i-1) and (i-1)(i+1) and (i+1)(i-1) and (i+1)(i+1) of them all 1
    // 3. init g = 1
    // 4. loop
    //    i from 1 to n-1
    //    j from 0 -> i-1
    //    if t[i][j] all 0, g++
    //    else g stay no changes
    // 5. return g

    val pplCount = related(0).length
    println(s"Total people: $pplCount")

    var relatedCopy: Array[String] = new Array[String](pplCount) //related.map(_.clone)

    var groupCount = 1

    for (i <- 0 until pplCount) {
      relatedCopy(i) = related(i)
    }
    println(s"relatedCopy before:")
    relatedCopy.foreach(x => println(x))

    for (i <- 1 until pplCount) {
      //    if (i-1)(i) and (i)(i-1) and (i+1)(i) and (i)(i+1) is 1,
      //    then make (i-1)(i-1) and (i-1)(i+1) and (i+1)(i-1) and (i+1)(i+1) of them all 1
      if ( (i > 0 && relatedCopy(i - 1)(i) == '1')
        && (i > 0 && relatedCopy(i)(i - 1) == '1')
        && (i < pplCount - 1 && relatedCopy(i + 1)(i) == '1')
        && (i < pplCount - 1 && relatedCopy(i)(i + 1) == '1') ) {
        if (i > 0 && relatedCopy(i - 1)(i - 1) == '0') {
          // update relatedCopy(i-1)(i-1) to '1'
          println(s"Need to update relatedCopy(${i - 1})(${i - 1}) from 0 to 1")
          println(s"relatedCopy(${i - 1}) before: ${relatedCopy(i - 1)}")
          relatedCopy(i - 1) = relatedCopy(i - 1).slice(0, i - 1) + '1' + relatedCopy(i - 1).slice(i, pplCount)
          println(s"relatedCopy(${i - 1}) after: ${relatedCopy(i - 1)}")
        }
        if (i > 0 && i < pplCount - 1 && relatedCopy(i - 1)(i + 1) == '0') {
          // update relatedCopy(i-1)(i+1) to '1'
          println(s"Need to update relatedCopy(${i - 1})(${i + 1}) from 0 to 1")
          println(s"relatedCopy(${i - 1}) before: ${relatedCopy(i - 1)}")
          relatedCopy(i - 1) = relatedCopy(i - 1).slice(0, i + 1) + '1' + relatedCopy(i - 1).slice(i + 2, pplCount)
          println(s"relatedCopy(${i - 1}) after: ${relatedCopy(i - 1)}")
        }
        if (i > 0 && i < pplCount - 1 && relatedCopy(i + 1)(i - 1) == '0') {
          // update relatedCopy(i+1)(i-1) to '1'
          println(s"Need to update relatedCopy(${i + 1})(${i - 1}) from 0 to 1")
          println(s"relatedCopy(${i + 1}) before: ${relatedCopy(i + 1)}")
          relatedCopy(i + 1) = relatedCopy(i + 1).slice(0, i - 1) + '1' + relatedCopy(i + 1).slice(i, pplCount)
          println(s"relatedCopy(${i + 1}) after: ${relatedCopy(i + 1)}")
        }
        if (i < pplCount - 1 && relatedCopy(i + 1)(i + 1) == '0') {
          // update relatedCopy(i+1)(i+1) to '1'
          println(s"Need to update relatedCopy(${i + 1})(${i + 1}) from 0 to 1")
          println(s"relatedCopy(${i + 1}) before: ${relatedCopy(i + 1)}")
          relatedCopy(i + 1) = relatedCopy(i + 1).slice(0, i + 1) + '1' + relatedCopy(i + 1).slice(i + 2, pplCount)
          println(s"relatedCopy(${i + 1}) after: ${relatedCopy(i + 1)}")
        }
      }
    }
    println(s"relatedCopy after:")
    relatedCopy.foreach(x => println(x))

    for (i <- 1 until pplCount) {
      var newGroup: Boolean = true
      breakable {
        for (j <- 0 until i) {
          println(s"$i $j: ${relatedCopy(i)(j)}")
          if (relatedCopy(i)(j) == '1') {
            println(s"Found relatedCopy($i)($j) is 1")
            newGroup = false
            break
          }
        }
      }
      println(s"Row $i: newGroup flag is $newGroup")
      if (newGroup) {
        groupCount = groupCount + 1
      }
    }

    println(s"There are $groupCount groups.")
    groupCount
  }
}

object Solution_fail2 {
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
