import java.io._
import scala.io._
import scala.language.implicitConversions
import scala.math._
import scala.util.Try

case class LogDataModel_good1(sender_user_id: BigInt, recipient_user_id: BigInt, amount_of_transaction: BigInt)

object Result_good1 {
  private implicit def string2BigInt(str: String): Option[BigInt] = Try(BigInt(str)).toOption
  /*
   * Complete the 'processLogs' function below.
   *
   * The function is expected to return a STRING_ARRAY.
   * The function accepts following parameters:
   *  1. STRING_ARRAY logs
   *  2. INTEGER threshold
   */

  def processLogs(logs: Array[String], threshold: Int): Array[String] = {
    val logRecord = logs.map { line =>
      val logCols = line.split(" ").map(_.trim)
      LogDataModel(BigInt(logCols(0)), BigInt(logCols(1)), BigInt(logCols(2)))
    }
    println("logRecord")
    logRecord.foreach(println(_))

    val idCountList1 = logRecord.groupBy(_.sender_user_id).view.mapValues(_.length).toList
    println("idCountList1")
    idCountList1.foreach(println(_))
    val idCountList2 = logRecord.filter(x => x.sender_user_id != x.recipient_user_id).groupBy(_.recipient_user_id)
      .view.mapValues(_.length).toList
    println("idCountList2")
    idCountList2.foreach(println(_))

    val mergedCountList = idCountList1 ++ idCountList2
    println("mergedCountList")
    mergedCountList.foreach(println(_))
    val mergedFilteredCountList = mergedCountList.groupBy(_._1).map { case (k, v) => k -> v.map(_._2).sum }.filter(_._2 >=
      threshold).toList.sortBy(_._1)
    println("mergedFilteredCountList")
    mergedFilteredCountList.foreach(println(_))

    mergedFilteredCountList.map(_._1.toString()).toArray
  }
}

object Solution_good1 {
  def main(args: Array[String]): Unit = {
    val printWriter = new PrintWriter(System.out); //sys.env("OUTPUT_PATH"))

    val logsCount = StdIn.readLine.trim.toInt

    val logs = Array.ofDim[String](logsCount)

    for (i <- 0 until logsCount) {
      val logsItem = StdIn.readLine
      logs(i) = logsItem
    }

    val threshold = StdIn.readLine.trim.toInt

    val result = Result.processLogs(logs, threshold)

    printWriter.println(result.mkString("\n"))

    printWriter.close()
  }
}