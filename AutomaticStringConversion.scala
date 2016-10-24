// AutomaticStringConversion.scala

import com.atomicscala.AtomicTest._

// 1.
case class Bicycle(riders: Int) {
  override def toString =
    s"Bicycle built for $riders"
}
val forTwo = Bicycle(2)
forTwo is "Bicycle built for 2"

// 2.
case class Cycle(riders: Int) {
  override def toString =
    riders match {
      case 1 => "Unicycle"
      case 2 => "Bicycle"
      case 3 => "Tricycle"
      case 4 => "Quandricycle"
      case _ if riders >= 0 => s"Cycle with $riders wheels"
      case _ => "That's not a cycle!"
    }
}

val c1 = Cycle(1)
c1 is "Unicycle"
val c2 = Cycle(2)
c2 is "Bicycle"
val cn = Cycle(5)
cn is "Cycle with 5 wheels"

// 3.
Cycle(-2) is "That's not a cycle!"
