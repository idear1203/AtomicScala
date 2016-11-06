// ConvertingExceptionswithTry.scala

import com.atomicscala.AtomicTest._
import util.{Try, Success, Failure}

// 1.
case class Except1(why:String)
  extends Exception(why)
case class Except2(n:Int)
  extends Exception(n.toString)
case class Except3(msg:String, d:Double)
  extends Exception(s"$msg $d")

def toss(which:Int) =
  which match {
    case 1 => throw Except1("Reason")
    case 2 => throw Except2(11)
    case 3 =>
      throw Except3("Wanted:", 1.618)
    case _ => "OK"
  }

def f(n:Int) = Try(toss(n)).transform(
  i => Success(s"$i Bob"), // Success
  e => e match { // Failure
    case Except1(why) => Success(why)
    case Except2(n) => Success(n)
    case Except3(msg, d) => Success(d)
  }
).get

f(0) is "OK Bob"
f(1) is "Reason"
f(2) is "11"
f(3) is "1.618"

// 2.
def f1(n:Int) = Try(toss(n)).transform(
  i => Success(s"$i Bob"), // Success
  e => e match { // Failure
    case Except1(why) => Success(why)
    case Except2(n) => Success(n)
    case Except3(msg, d) => Success(d)
  }
)

f1(0) is Success("OK Bob")
f1(1) is Success("Reason")
f1(2) is Success(11)
f1(3) is Success(1.618)

// 3.
import codelisting._
import java.io.FileNotFoundException

def listing(name:String) =
  Try(new CodeListing(name)).recover{
    case _:FileNotFoundException =>
      Vector(s"File Not Found: $name")
    case _:NullPointerException =>
      Vector("Error: Null file name")
    case e:ExtensionException =>
      Vector(e.getMessage)
  }.get

class CodeListingTester(makeList: String => IndexedSeq[String]) {
  val list = makeList("NotAFile.scala")
  for (i <- Range(0, list.size)) {
    println(f"${i + 1}%2d, ${list(i)}")
  }
}

new CodeListingTester(listing)
