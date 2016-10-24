// Review2.scala

import com.atomicscala.AtomicTest._
import com.atomicscala.exercise.BasicMethods
import com.atomicscala.exercise.NoBody
import com.atomicscala.exercise.SomeBody
import com.atomicscala.exercise.EveryBody

// 1.
val v1 = Vector('h', 'e', 'l', 'l', 'o')
val v2 = Vector(1, 2, 3)
val v3 = Vector("hello", "world")

v1.min is 'e'
v1.max is 'o'
v1.sorted.mkString(" ") is "e h l l o"

v2.min is 1
v2.max is 3
v2.sorted.mkString(" ") is "1 2 3"

v3.min is "hello"
v3.max is "world"
v3.sorted.mkString(" ") is "hello world"

// 2.
val v4 = Vector(v1, v2, v3)
var createdString = ""
for (vector <- v4) {
  for (element <- vector) {
    createdString += element + " ";
  }
}

createdString is "h e l l o 1 2 3 hello world "

// 3.
// v5: scala.collection.immutable.Vector[Any] = Vector(a, 1, b, 1.1)
val v5 = Vector('a', 1, "b", 1.1)
// error: No implicit Ordering defined for Any.
//v5.max is "b"
// error: No implicit Ordering defined for Any.
//v5.min is "1"

// 4.
val basicMethods = new BasicMethods
basicMethods.cube(3) is 27
basicMethods.bang("pop") is "pop!"

// 5.
val noBody = new NoBody
val someBody = new SomeBody
val everyBody = new EveryBody

noBody.className is "NoBody"
someBody.className is "SomeBody"
everyBody.className is "EveryBody"

// 6. See Temperature.scala

// 7. 8. See TicTacToe.scala
