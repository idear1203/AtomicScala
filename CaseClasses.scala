// CaseClasses.scala

import com.atomicscala.AtomicTest._

// 1.
case class Person( first: String,  last: String,  email: String)
val p = Person("Jane", "Smile", "jane@smile.com")
p.first is "Jane"
p.last is "Smile"
p.email is "jane@smile.com"

// 2.
val people = Vector(
Person("Jane", "Smile", "jane@smile.com"),
Person("Ron", "House", "ron@house.com"),
Person("Sally", "Dove", "sally@dove.com"))
people(0) is
"Person(Jane,Smile,jane@smile.com)"
people(1) is
"Person(Ron,House,ron@house.com)"
people(2) is
"Person(Sally,Dove,sally@dove.com)"

// 3.
case class Dog(name: String, species: String)
val dogs = Vector(
Dog("Fido", "Golden Lab"),
Dog("Ruff", "Alaskan Malamute"),
Dog("Fifi", "Miniature Poodle"))
dogs(0) is
"Dog(Fido,Golden Lab)"
dogs(1) is
"Dog(Ruff,Alaskan Malamute)"
dogs(2) is
"Dog(Fifi,Miniature Poodle)"

// 4.
case class Dimension(var height: Int, var width: Int)
val c = new Dimension(5, 7)
c.height is 5
c.height = 10
c.height is 10
c.width = 19
c.width is 19

// 5.

// 6.
case class SimpleTimeDefault(hours: Int, minutes: Int = 0) {
    def substract(other: SimpleTimeDefault): SimpleTimeDefault = {
        val difference = getValue() - other.getValue()
        if (difference > 0) {
            SimpleTimeDefault(difference / 60, difference % 60)
        } else {
            SimpleTimeDefault(0)
        }
    }

    def getValue(): Int = {
        hours * 60 + minutes
    }
}

val anotherT1 = SimpleTimeDefault(10, 30)
val anotherT2 = SimpleTimeDefault(9)
val anotherST = anotherT1.substract(anotherT2)
anotherST.hours is 1
anotherST.minutes is 30
val anotherST2 = SimpleTimeDefault(10).
    substract(SimpleTimeDefault(9, 45))
anotherST2.hours is 0
anotherST2.minutes is 15
