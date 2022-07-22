import scala.util.control._

class Solution {
  //Write your code here
  var myStack: List[Char] = List[Char]();
  var myQueue: List[Char] = List[Char]();

  def pushCharacter(c: Char): Unit = {
    myStack = c :: myStack
  }

  def popCharacter(): Char = {
    val c = myStack.head
    myStack = myStack.tail
    c
  }

  def enqueueCharacter(c: Char): Unit = {
    myQueue = myQueue ::: List(c)
  }

  def dequeueCharacter(): Char = {
    val c = myQueue.head
    myQueue = myQueue.tail
    c
  }
}

object Solution {
  def main(args: Array[String]) {
    // read the string s
    var s = scala.io.StdIn.readLine();
    // create the Solution class object p
    var obj = new Solution();
    var i = 0;
    var len = s.length();
    //push/enqueue all the characters of string s to stack
    for (i <- 0 to len - 1) {
      obj.pushCharacter(s.charAt(i));
      obj.enqueueCharacter(s.charAt(i));
    }

    var isPalindrome = true;
    /*pop the top character from stack
      dequeue the first character from queue
      compare both the characters*/

    val loop = new Breaks;
    loop.breakable {
      for (i <- 0 to len / 2) {
        //if (obj.popCharacter() != obj.dequeueCharacter()) {
        val s = obj.popCharacter()
        val q = obj.dequeueCharacter()
        if (s != q) {
          isPalindrome = false;
          loop.break;
        }
      }
    }

    //finally print whether string s is palindrome or not
    if (isPalindrome) {
      println("The word, " + s + ", is a palindrome.");
    }
    else {
      println("The word, " + s + ", is not a palindrome.");
    }
  }
}