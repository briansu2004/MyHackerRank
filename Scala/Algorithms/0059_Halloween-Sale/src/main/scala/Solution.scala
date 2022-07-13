import java.io._
import java.math._
import java.util._
import java.util.concurrent._
import scala.collection.immutable._
import scala.io._

object Result {

  /*
   * Complete the 'howManyGames' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER p
   *  2. INTEGER d
   *  3. INTEGER m
   *  4. INTEGER s
   */
  //  def gamePrices(p: Int, d: Int, m: Int): LazyList[Int] = {
  //    p #:: (p - d) #:: gamePrices(p, d, m).zip(gamePrices(p, d, m).tail).map { n => if (n._2 - d > m) n._2 - d else m }
  //  }
  //
  //  def gameCostAccu(p: Int, d: Int, m: Int): LazyList[Int] = {
  //    gamePrices(p, d, m).map(n => gamePrices(p, d, m).slice(0, gamePrices(p, d, m).indexOf(n) + 1).sum)
  //  }
  //
  //  def howManyGames(p: Int, d: Int, m: Int, s: Int): Int = {
  //    // Return the number of games you can buy
  //    //gameCostAccu(20, 3, 6).takeWhile(x => x <= 70).length
  //    gameCostAccu(p, d, m).takeWhile(x => x <= s).length
  //  }

  def howManyGames(pp: Int, d: Int, m: Int, ss: Int): Int = {
    var cnt = 0
    var p = pp
    var s = ss
    while (s >= p) {
      cnt += 1
      s -= p
      p = Math.max(m, p - d)
    }
    cnt
  }
}

object Solution {
  def main(args: Array[String]) {
    val printWriter = new PrintWriter(System.out)

    val firstMultipleInput = StdIn.readLine.replaceAll("\\s+$", "").split(" ")

    val p = firstMultipleInput(0).toInt

    val d = firstMultipleInput(1).toInt

    val m = firstMultipleInput(2).toInt

    val s = firstMultipleInput(3).toInt

    val answer = Result.howManyGames(p, d, m, s)

    printWriter.println(answer)

    printWriter.close()
  }
}
