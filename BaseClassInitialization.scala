// BaseClassInitialization.scala

import com.atomicscala.AtomicTest._

// 1.
class GreatApe(
  val weight: Double, val age: Int, val gender: String)

class Bonobo(weight: Double, age: Int, gender: String)
  extends GreatApe(weight, age, gender)
class Chimpanzee(weight: Double, age: Int, gender: String)
  extends GreatApe(weight, age, gender)
class BonoboB(weight: Double, age: Int, gender: String)
  extends Bonobo(weight, age, gender)
class BonoboC(weight: Double, age: Int, gender: String)
  extends BonoboB(weight, age, gender)

def display(ape: GreatApe) =
  s"weight: ${ape.weight} age: ${ape.age} gender: ${ape.gender}"

display(new GreatApe(100, 12, "Male")) is
"weight: 100.0 age: 12 gender: Male"
display(new Bonobo(100, 12, "Female")) is
"weight: 100.0 age: 12 gender: Female"
display(new Chimpanzee(100, 12, "Male")) is
"weight: 100.0 age: 12 gender: Male"
display(new BonoboB(100, 12, "Male")) is
"weight: 100.0 age: 12 gender: Male"
display(new BonoboC(150, 18, "Female")) is
"weight: 150.0 age: 18 gender: Female"

// 2.

// 3.
class House

class Home extends House {
  val heart = true
  override def toString =
    "Where is the heart is"
}

val h = new Home
h.toString is "Where is the heart is"
h.heart is true

// 4.
class VacationHouse(state: String, zip: String, startMonth: Int, endMonth: Int) {
  def getMonth(month: Int) = {
    month match {
      case 1 => "January"
      case 2 => "February"
      case 3 => "Match"
      case 4 => "April"
      case 5 => "May"
      case 6 => "June"
      case 7 => "July"
      case 8 => "August"
      case 9 => "September"
      case 10 => "October"
      case 11 => "November"
      case 12 => "December"
      case _ => "Unknown month"
    }
  }
  override def toString =
    s"Rented house in $state for months of ${getMonth(startMonth)} through ${getMonth(endMonth)}."
}

val v = new VacationHouse("MI", "49431", 6, 8)
v is "Rented house in MI for months of " +
  "June through August."

// 5.
class Trip(
  val origination: String,
  val destination: String,
  val startDate: String,
  val endDate: String) {
  override def toString = 
    s"From $origination to $destination: $startDate to $endDate"
}

class AirplaneTrip(origination: String, destination: String,
  startDate: String, endDate: String, movie: String)
  extends Trip(origination, destination, startDate, endDate) {
    override def toString =
      s"On a filght from $origination to $destination: $startDate to $endDate, we watched $movie"
}

class CarTrip(cities: Vector[String], startDate: String, endDate: String)
  extends Trip(cities.head, cities.last, startDate, endDate)

val t = new Trip("Detroit","Houston",
  "5/1/2012","6/1/2012")
val a = new AirplaneTrip("Detroit",
  "London","9/1/1939",
  "10/31/1939", "Superman")
val cities = Vector("Boston",
  "Albany","Buffalo","Cleveland",
  "Columbus","Indianapolis",
  "St. Louis", "Kansas City",
  "Denver", "Grand Junction",
  "Salt Lake City", "Las Vegas",
  "Bakersfield", "San Francisco")
val c = new CarTrip(cities,
  "6/1/2012", "7/1/2012")
c.origination is "Boston"
c.destination is "San Francisco"
c.startDate is "6/1/2012"
t is "From Detroit to Houston: 5/1/2012 to 6/1/2012"
c is "From Boston to San Francisco: 6/1/2012 to 7/1/2012"

// 6.

// 7.

// 8.
case class Person(name: String)
class Programmer(name: String, dream: String) extends Person(name)

val me = new Programmer("Aaron", "Freedom and inner-peace")
me is "Person(Aaron)"

// error: case class Programmer has case ancestor Main.$anon.Person, but case-to-case inheritance is prohibited. To overcome this limitation, use extractors to pattern match on non-leaf nodes.
// case class Person(name: String)
// case class Programmer(name: String, dream: String) extends Person(name)

