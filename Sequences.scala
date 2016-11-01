// Sequences.scala

import com.atomicscala.AtomicTest._

// 1.
case class Person(first: String, last: String, email: String) {
  def fullName =
    s"$first $last"
}

val p = Person("John", "Smith", "john@smith.com")
p.fullName is "John Smith"
p.first is "John"
p.email is "john@smith.com"

// 2.
val p1 = Person("John", "Smith", "john@smith.com")
val p2 = Person("Bruce", "Eckel", "bruce@eckel.com")
val p3 = Person("Dianne", "Marsh", "dianne@marsh.com")
val people1 = Vector(p1, p2, p3)
people1.size is 3

// 3.
val people = Vector(
  Person("Zach","Smith","zach@smith.com"),
  Person("Mary", "Add", "mary@add.com"),
  Person("Sally", "Taylor", "sally@taylor.com")
)

val sorted = people.sortBy(_.last)

sorted is "Vector(" +
  "Person(Mary,Add,mary@add.com), " +
  "Person(Zach,Smith,zach@smith.com), " +
  "Person(Sally,Taylor,sally@taylor.com))"

// 4.
trait Contact {
  val email: String
}

class Person1(val first: String, val last: String) {
  override def toString =
    s"$first $last"
}

class Friend(first: String, last: String, val email: String)
  extends Person1(first, last) with Contact

val friends = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally","Taylor","sally@taylor.com")
  )
val sorted4 = friends.sortBy(_.email)
sorted4 is "Vector(Mary Add, Sally Taylor, Zach Smith)"

// 5.
val friends2 = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally","Taylor","sally@taylor.com"),
  new Friend("Mary", "Smith", "mary@smith.com")
  )

val s1 = friends2.sortBy(_.first)
val s2 = s1.sortBy(_.last)
s2 is "Vector(Mary Add, Mary Smith, Zach Smith, Sally Taylor)"

// 6.
val friends3 = Vector(
  new Friend("Zach", "Smith", "zach@smith.com"),
  new Friend("Mary", "Add", "mary@add.com"),
  new Friend("Sally","Taylor","sally@taylor.com"),
  new Friend("Mary", "Smith", "mary@smith.com")
)

val s3 = friends3.sortBy(_.last)
val s4 = friends3.sortBy(_.first)
s4 is "Vector(Mary Add, Mary Smith, Sally Taylor, Zach Smith)"
