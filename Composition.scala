// Composition.scala

import com.atomicscala.AtomicTest._

// 1.
trait Mobility {
  def mobility: String
}

trait Vision {
  def vision: String
}

trait Manipulator {
  def manipulator: String
}

//class Robot(mobility: String, vision: String, manipulator: String)
class Robot(val mobility: String, val vision: String, val manipulator: String)
  extends Mobility with Vision with Manipulator {
  override def toString =
    s"$mobility, $vision, $manipulator"
}

val walker = new Robot("Legs",
  "Visible Spectrum", "Magnet")
walker is
  "Legs, Visible Spectrum, Magnet"
val crawler = new Robot("Treads",
  "Infrared", "Claw")
crawler is "Treads, Infrared, Claw"
val arial = new Robot("Propeller",
  "UV", "None")
arial is "Propeller, UV, None"

// 2.
case class Mobility2(mobility: String)

case class Vision2(vision: String)

case class Manipulator2(manipulator: String)

class Robot2(mobility: Mobility2, vision: Vision2, manipulator: Manipulator2) {
  override def toString =
    s"$mobility, $vision, $manipulator"
}

val walker2 = new Robot2(
  Mobility2("Legs"),
  Vision2("Visible Spectrum"),
  Manipulator2("Magnet"))
walker2 is "Mobility2(Legs), " +
  "Vision2(Visible Spectrum)," +
  " Manipulator2(Magnet)"
val crawler2 = new Robot2(
  Mobility2("Treads"),
  Vision2("Infrared"),
  Manipulator2("Claw"))
crawler2 is "Mobility2(Treads)," +
  " Vision2(Infrared), " +
  "Manipulator2(Claw)"
val arial2 = new Robot2(
  Mobility2("Propeller"),
  Vision2("UV"),
  Manipulator2("None"))
arial2 is "Mobility2(Propeller)," +
  " Vision2(UV), Manipulator2(None)"

// 3.
case class Mobility3(mobility: String)

case class Vision3(vision: String)

case class Manipulator3(manipulator: String)

class Robot3(
  mobilities: Vector[Mobility3],
  visions: Vector[Vision3],
  manipulators: Vector[Manipulator3]) {
  override def toString =
    s"${mobilities.mkString(", ")} | ${visions.mkString(", ")} | ${manipulators.mkString(", ")}"
}

val bot = new Robot3(
  Vector(
    Mobility3("Propeller"),
    Mobility3("Legs")),
  Vector(
    Vision3("UV"),
    Vision3("Visible Spectrum")),
  Vector(
    Manipulator3("Magnet"),
    Manipulator3("Claw"))
)

bot is "Mobility3(Propeller)," +
" Mobility3(Legs) | Vision3(UV)," +
" Vision3(Visible Spectrum) | " +
"Manipulator3(Magnet), " +
"Manipulator3(Claw)"

// 4.
trait Ability

case class Mobility4(mobility: String) extends Ability

case class Vision4(vision: String) extends Ability

case class Manipulator4(manipulator: String) extends Ability

class Robot4(abilities: Vector[Ability]) {
  override def toString =
    abilities.mkString(", ")
}

val bot4 = new Robot4(
  Vector(Mobility4("Propeller"),
    Mobility4("Legs"),
    Vision4("UV"),
    Vision4("Visible Spectrum"),
    Manipulator4("Magnet"),
    Manipulator4("Claw"))
)

bot4 is "Mobility4(Propeller), " +
"Mobility4(Legs), Vision4(UV), " +
"Vision4(Visible Spectrum), " +
"Manipulator4(Magnet), " +
"Manipulator4(Claw)"

// 5.
case class Mobility5(mobility: String) extends Ability

case class Vision5(vision: String) extends Ability

case class Manipulator5(manipulator: String) extends Ability

class Robot5 {
  var mobilities = Vector[Mobility5]()
  var visions = Vector[Vision5]()
  var manipulators = Vector[Manipulator5]()
  def addMobility(mobility: Mobility5) =
    mobilities = mobilities :+ mobility
  def addVision(vision: Vision5) =
    visions = visions :+ vision
  def addManipulator(manipulator: Manipulator5) =
    manipulators = manipulators :+ manipulator
  override def toString =
    s"${mobilities.mkString(", ")} | ${visions.mkString(", ")} | ${manipulators.mkString(", ")}"
}

val bot5 = new Robot5
bot5.addMobility(
  Mobility5("Propeller"))
bot5.addMobility(
  Mobility5("Legs"))
bot5.addVision(
  Vision5("UV"))
bot5.addVision(Vision5(
  "Visible Spectrum"))
bot5.addManipulator(
  Manipulator5("Magnet"))
bot5.addManipulator(
  Manipulator5("Claw"))

bot5 is "Mobility5(Propeller)," +
" Mobility5(Legs) | Vision5(UV)," +
" Vision5(Visible Spectrum) | " +
"Manipulator5(Magnet)," +
" Manipulator5(Claw)"

// 6.
case class Mobility6(mobility: String) extends Ability

case class Vision6(vision: String) extends Ability

case class Manipulator6(manipulator: String) extends Ability

class Robot6 {
  var mobilities = Vector[Mobility6]()
  var visions = Vector[Vision6]()
  var manipulators = Vector[Manipulator6]()
  def +(mobility: Mobility6) = {
    mobilities = mobilities :+ mobility
    this
  }
  def +(vision: Vision6) = {
    visions = visions :+ vision
    this
  }
  def +(manipulator: Manipulator6) = {
    manipulators = manipulators :+ manipulator
    this
  }
  override def toString =
    s"${mobilities.mkString(", ")} | ${visions.mkString(", ")} | ${manipulators.mkString(", ")}"
}

val bot6 = new Robot6 +
  Mobility6("Propeller") +
  Mobility6("Legs") +
  Vision6("UV") +
  Vision6("Visible Spectrum") +
  Manipulator6("Magnet") +
  Manipulator6("Claw")

bot6 is "Mobility6(Propeller)," +
" Mobility6(Legs) | Vision6(UV)," +
" Vision6(Visible Spectrum) |" +
" Manipulator6(Magnet)," +
" Manipulator6(Claw)"
