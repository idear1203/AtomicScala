// TaggingTrait.scala
import com.atomicscala.AtomicTest._

// 1. warning: match may not be exhaustive.
//sealed trait Color
//case object Red extends Color
//case object Green extends Color
//case object Blue extends Color
//case object Purple extends Color
//object Color {
//  val values = Vector(Red, Green, Blue)
//}
//
//def display(c:Color) = c match {
//  case Red => s"It's $c"
//  case Green => s"It's $c"
//  case Blue => s"It's $c"
//}
//
//Color.values.map(display) is
//"Vector(It's Red, It's Green, It's Blue)"

// 2.
object EnumColor extends Enumeration {
  type EnumColor = Value
  val Red, Blue, Green = Value
}

EnumColor.Red is "Red"
EnumColor.Blue is "Blue"
EnumColor.Green is "Green"

// 3. error: Red is already defined as value Red

// 4. error: Red is already defined as case class Red
