// CombiningSequenceswithzip.scala

import com.atomicscala.AtomicTest._

// 1.
val people = Vector("Sally Smith",
  "Dan Jones", "Tom Brown", "Betsy Blanc",
  "Stormy Morgan", "Hal Goodsen")

val group1 = Vector("Sally Smith", "Dan Jones", "Tom Brown")
val group2 = Vector("Betsy Blanc", "Stormy Morgan", "Hal Goodsen")
val pairs = group1.zip(group2)

pairs is Vector(
  ("Sally Smith","Betsy Blanc"),
  ("Dan Jones","Stormy Morgan"),
  ("Tom Brown","Hal Goodsen"))

// 2.
val group3 = Vector("Sally Smith", "Dan Jones")
val group4 = Vector("Betsy Blanc", "Stormy Morgan", "Hal Goodsen", "Tom Brown")
val pairs2 = group3.zip(group4)
val pairs3 = group4.zip(group3)

pairs2 is Vector(
  ("Sally Smith", "Betsy Blanc"),
  ("Dan Jones", "Stormy Morgan")
)

pairs3 is Vector(
  ("Betsy Blanc", "Sally Smith"),
  ("Stormy Morgan", "Dan Jones")
)

// 3.
val group5 = List("Sally Smith", "Dan Jones", "Tom Brown")
val group6 = List("Betsy Blanc", "Stormy Morgan", "Hal Goodsen")
val pairs4 = group5.zip(group6)

pairs4 is List(
  ("Sally Smith","Betsy Blanc"),
  ("Dan Jones","Stormy Morgan"),
  ("Tom Brown","Hal Goodsen"))

// 4.
def number(s: String) =
  s.zipWithIndex.map {
    case (ch, n) => (n, ch)
  }

number("Howdy") is Vector(
  (0, 'H'), (1, 'o'), (2, 'w'), (3, 'd'), (4, 'y')
)
