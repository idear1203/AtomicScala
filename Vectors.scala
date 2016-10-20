// Vectors.scala

import com.atomicscala.AtomicTest._

// 1.
val v1 = Vector(1, 3, 5, 7, 9)
val v2 = Vector(1.1, 2.2, 3.3, 4.4)
val v3 = Vector("hello", "world")

// 2.
val v4 = Vector(Vector(1, 3, 5, 7, 9), Vector(2, 4, 6, 8, 10))
var result = "";
v4.foreach(v => result += v.mkString(" ") + " ")
result is "1 3 5 7 9 2 4 6 8 10 "

// 3.
val v5 = Vector("The", "dog", "visited", "the", "firehouse")
var sentence = ""
for (word <- v5) {
    sentence += word + " "
}

sentence.toString() is
    "The dog visited the firehouse "

// 4.
val theString = sentence.replace(" firehouse ", " firehouse!")
theString is 
    "The dog visited the firehouse!"

// 5.
for (word <- v5) {
    println(word.reverse)
}

// 6.
for (word <- v5.reverse) {
    println(word)
}

// 7.
//val v1 = Vector(1, 3, 5, 7, 9)
//val v2 = Vector(1.1, 2.2, 3.3, 4.4)
v1.sum is 25
v1.max is 9
v1.min is 1
v2.sum is 11
v2.max is 4.4
v2.min is 1.1

// 8.
//val v3 = Vector("hello", "world")
// error: could not find implicit value for parameter num: Numeric[String]
//println(v3.sum)
v3.min is "hello"
v3.max is "world"

// 9.
val r1 = Range(0, 5).inclusive
for (number <- r1) {
    r1.sum is 15
}

// 10 - 11.
val list = List("The", "dog", "dog", "visited", "the", "firehouse")
val set = Set("The", "dog", "dog", "visited", "the", "firehouse")
println(list)
println(list.reverse)
println(list.sorted)
println(set)
// error: value reverse is not a member of scala.collection.immutable.Set[String]
//println(set.reverse)
// error: value sorted is not a member of scala.collection.immutable.Set[String]
//println(set.sorted)

// 12.
val myVector1 = Vector(1, 2, 3, 4, 5, 6)
val myVector2 = Vector(1, 2, 3, 4, 5, 6)
myVector1 is myVector2
