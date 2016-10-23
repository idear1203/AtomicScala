// FunctionAsObjects.scala

import com.atomicscala.AtomicTest._

// 1.
var s = ""
val v1 = Vector(1, 2, 3, 4)
v1.foreach(n => s += n)
s is "1234"

// 2.
var str = ""
v1.foreach(n => str += n + ",")
str is "1,2,3,4,"

// 3.
val dogYears = (n: Int) => n * 7
dogYears(10) is 70

// 4.
s = ""
val v = Vector(1, 5, 7, 8)
v.foreach(n => s += dogYears(n) + " ")
s is "7 35 49 56 "

// 5.
s = ""
v.foreach(n => s += (n * 7) + " ")
s is "7 35 49 56 "

// 6.
val between = (temperature: Int, low: Int, high: Int) => (low <= temperature && temperature <= high)
between(70, 80, 90) is false
between(70, 60, 90) is true

// 7.
s = ""
val numbers = Vector(1, 2, 5, 3, 7)
numbers.foreach(n => s += n * n + " ")
s is "1 4 25 9 49 "

// 8.
val pluralize = (word: String) => word + "s"
pluralize("cat") is "cats"
pluralize("dog") is "dogs"
pluralize("silly") is "sillys"

// 9.
s = ""
val words = Vector("word", "cat", "animal")
words.foreach(x => s += pluralize(x) + " ")
s is "words cats animals "
