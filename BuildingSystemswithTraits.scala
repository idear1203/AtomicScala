// BuildingSystemswithTraits.scala

import com.atomicscala.AtomicTest._

// 1.
object Shot extends Enumeration {
  type Shot = Value
  val Single, Double = Value
}
import Shot._

object Caffeine extends Enumeration {
  type Caffeine = Value
  val HalfCaf, Caf, Decaf = Value
}
import Caffeine._

object Milk extends Enumeration {
  type Milk = Value
  val Skim, NoMilk = Value
}
import Milk._

object Cup extends Enumeration {
  type Cup = Value
  val ToGo, Here = Value
}
import Cup._

object Syrup extends Enumeration {
  type Syrup = Value
  val Choc, NoFlavor = Value
}
import Syrup._

case class Coffee(
  shot: Shot,
  decaf: Caffeine, 
  toGo: Cup,
  milk: Milk,
  syrup: Syrup
  )

Coffee(Single, Caf, Here, Skim, Choc) is
  "Coffee(Single,Caf,Here,Skim,Choc)"
Coffee(Double, Caf, Here, NoMilk, NoFlavor) is
  "Coffee(Double,Caf,Here,NoMilk,NoFlavor)"
Coffee(Double, HalfCaf, ToGo, Skim, Choc) is
  "Coffee(Double,HalfCaf,ToGo,Skim,Choc)"

// 2.
class Latte(
  shot: Shot,
  decaf: Caffeine, 
  toGo: Cup,
  milk: Milk
  ) {
  override def toString =
    s"Latte($shot,$decaf,$toGo,$milk)"
}


class Coffee2(
  shot: Shot,
  decaf: Caffeine, 
  toGo: Cup
  ) {
  override def toString =
    s"Coffee2($shot,$decaf,$toGo)"
}

val latte = new Latte(Single, Caf, Here, Skim)
latte is "Latte(Single,Caf,Here,Skim)"
val usual = new Coffee2(Double, Caf, Here)
usual is "Coffee2(Double,Caf,Here)"

// 3.
class Mocha(
  shot: Shot,
  decaf: Caffeine, 
  toGo: Cup,
  milk: Milk)
  extends Coffee(shot, decaf, toGo, milk, Choc) {
    override def toString =
      s"Mocha($shot,$decaf,$toGo,$milk,$syrup)"
  }
  
val mocha = new Mocha(Double,Caf,ToGo,Skim)
mocha is "Mocha(Double,Caf,ToGo,Skim,Choc)"

// 4.
