// ReferencesAndMutability.scala

import com.atomicscala.AtomicTest._

// 1.
var m1 = Map("Aaron" -> true, "George" -> true, "David" -> false, "idear" -> "true")
val m2 = Map("Aaron" -> true, "George" -> true, "David" -> false, "idear" -> "true")

// 2.
// Mutable set
val s1 = collection.mutable.Set("a", "b", "a", "a", "b", "c")
s1 += "d"
s1 is collection.mutable.Set("a", "b", "c", "d")

// Immutable set
var s3 = Set("a", "b", "a", "a", "b", "c")
s3 += "d"
s1 is Set("a", "b", "c", "d")

// 3.
// TODO: discover features of mutablelist
//val l1 = collection.mutable.MutableList("a", "b", "a", "a", "b", "c")
//l1 += "d"
//l1 is collection.mutable.MutableList("a", "b", "a", "a", "b", "c", "d")

// Immutable list. Update operations will lead to creating new collection
var l2 = List("a", "b", "a", "a", "b", "c")

// Prepends a single element to this list.
l2 +:= "z"

// Appends a single element to this list.
l2 :+= "d"
l2 = "y" :: l2
l2 is List("y", "z", "a", "b", "a", "a", "b", "c", "d")

// 4.
var v1 = Vector("hello", "world")
v1 is Vector("hello", "world")
v1 +:= "idear"
v1 is Vector("idear", "hello", "world")
v1 :+= "scala"
v1 is Vector("idear", "hello", "world", "scala")
v1 ++ "atom" is Vector("idear", "hello", "world", "scala", 'a', 't', 'o', 'm')
v1 = v1 ++ Vector("atom")
v1 is Vector("idear", "hello", "world", "scala", "atom")

// 5.
class Person(var name: String)
def test5(p: Person) = {
// error: reassignment to val
//  p = new Person("idear")
}

// 6.
def testAssignField(p: Person) = {
  p.name = "Aaron"
}

val p = new Person("idear")
testAssignField(p)
p.name is "Aaron"

// 7.
