// PatternMatchingCaseClasses.scala

import com.atomicscala.AtomicTest._

// 1.
case class Passenger(
                      first: String, last: String)

case class Train(
                  travelers: Vector[Passenger],
                  line: String)

case class Bus(
                passengers: Vector[Passenger],
                capacity: Int)

case class Plane(
                  passengers: Vector[Passenger],
                  name: String)

def travel(transport: Any): String = {
  transport match {
    case Train(travelers, line) =>
      s"Train line $line $travelers"
    case Bus(travelers, seats) =>
      s"Bus size $seats $travelers"
    case Plane(travelers, name) =>
      s"Plane $name $travelers"
    case Passenger => "Walking along"
    case what => s"$what is in limbo!"
  }
}

val travelers = Vector(
  Passenger("Harvey", "Rabbit"),
  Passenger("Dorothy", "Gale"))

val trip2 = Vector(
  Train(travelers, "Reading"),
  Plane(travelers, "B757"),
  Bus(travelers, 100))
travel(trip2(1)) is "Plane B757 Vector(Passenger(Harvey,Rabbit), Passenger(Dorothy,Gale))"

// 2.
def travel2(transport: Any): String = {
  transport match {
    case Train(travelers, line) =>
      s"Train line $line $travelers"
    case Bus(travelers, seats) =>
      s"Bus size $seats $travelers"
    case Plane(travelers, name) =>
      s"Plane $name $travelers"
    case Passenger(first, last) => s"$first is walking"
    case what => s"$what is in limbo!"
  }
}
travel2(Passenger("Sally", "Marie")) is "Sally is walking"

// 3.
case class Kitten(name: String)

travel2(Kitten("Kitty")) is "Kitten(Kitty) is in limbo!"
