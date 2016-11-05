// Maps.scala

import com.atomicscala.AtomicTest._

// 1.

// 2.
case class Name(firstName: String, lastName: String)

val m = Map("sally@taylor.com" -> Name("Sally", "Taylor"))
m("sally@taylor.com") is
Name("Sally", "Taylor")

// 3.
val m2 = m + ("jiminy@cricket.com" -> Name("Jiminy", "Cricket"))
m2("jiminy@cricket.com") is
Name("Jiminy", "Cricket")
m2("sally@taylor.com") is
Name("Sally", "Taylor")

// 4.
val m3 = Map("English" -> "", "French" -> "", "Spanish" ->"",
  "German" -> "", "Chinese" -> "")
m3.size is 5
val m4 = m3 + ("Truikish" -> "")
m4. size is 6
m4("Truikish") is ""

// 5.
val m5 = m3 + ("Truikish" -> "newValue")
m5. size is 6
m5("Truikish") is "newValue"

// 6.
val m6 = m4 - "Spanish"
m6.size is 5
m6.contains("Spanish") is false

val m7 = m2 - "jiminy@cricket.com"
m7.size is 1
m7.contains("jiminy@cricket.com") is false

// 7.
case class Person(name: String)

val m8 = Map(Person("Janice") -> "CFO")
m8(Person("Janice")) is "CFO"
