// ConstructorsAndExceptions.scala

import com.atomicscala.AtomicTest._
import codelisting._

// 1.
class CodeListingTester1(
  makeList: String => IndexedSeq[String]
) {
  makeList("ConstructorsAndExceptions.scala").foreach(println)
}

new CodeListingTester1(CodeListing.apply)

// 2.
class CodeListingTester2(
  makeList: String => IndexedSeq[String]
) {
  val lines = makeList("ConstructorsAndExceptions.scala")
  for (i <- Range(0, lines.size)) {
    // Uses formatted strings
    println(f"${i + 1}%2d ${lines(i)}")
  }
}

new CodeListingTester2(CodeListing.apply)

// 3.
class CodeListingTester3(
  makeList: String => IndexedSeq[String]
) {
  val lines = makeList("NotAFile.scala")
  for (i <- Range(0, lines.size)) {
    // Uses formatted strings
    println(f"${i + 1}%2d ${lines(i)}")
  }
}

new CodeListingTester3(CodeListing.apply)
