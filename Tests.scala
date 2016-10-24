// Tests.scala

import com.atomicscala.AtomicTest._

// 1.
val myValue1 = 20
val myValue2 = 10

myValue1 is myValue2

// 2.
val myValue3 = 10
val myValue4 = 10

myValue3 is myValue4

// 3.
myValue2 is myValue3

// 4.
val myValue5 = "10"

myValue2 is myValue5

// 5.
