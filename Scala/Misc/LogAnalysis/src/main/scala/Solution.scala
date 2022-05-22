import java.io._
import scala.io._
import scala.language.implicitConversions
import scala.math._
import scala.util.Try

case class LogDataModel(sender_user_id: BigInt, recipient_user_id: BigInt, amount_of_transaction: BigInt)

object Result {
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

    val idCountList1 = logRecord.groupBy(_.sender_user_id).view.mapValues(_.length).toList
    val idCountList2 = logRecord.filter(x => x.sender_user_id != x.recipient_user_id).groupBy(_.recipient_user_id)
      .view.mapValues(_.length).toList

    val mergedCountList = idCountList1 ++ idCountList2
    val mergedFilteredCountList = mergedCountList.groupBy(_._1).map { case (k, v) => k -> v.map(_._2).sum }.filter(_._2 >=
      threshold).toList.sortBy(_._1)

    mergedFilteredCountList.map(_._1.toString()).toArray
  }
}

object Solution {
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