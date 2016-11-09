// ClassesAndObjects.scala

// 1.
val r1 = Range(0, 10)
println(r1.step)
val r2 = Range(0, 10, 2)
println(r2)
println(r2.step)

// 2.
val s = "This is an experiment"
val result = s.split(" ")
result.foreach(s => println(s))

// 3.
def isArg1EqualsArg2(s1: String, s2: String): Unit = {
  if (s1.equals(s2)) {
    println("s1 and s2 are equal")
  } else {
    println("s1 and s2 are not equal")
  }
}

var s1 = "Sally"
var s2 = "Sally"
isArg1EqualsArg2(s1, s2)

// 4.
s2 = "Sam"
isArg1EqualsArg2(s1, s2)

// 5.
val s3 = s1.toUpperCase()
if (s1.contentEquals(s3)) {
  println("s1 and s3 are equal")
} else {
  println("s1 and s3 are not equal")
}

