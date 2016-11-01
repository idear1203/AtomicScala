// TypeParameterConstraints.scala

import com.atomicscala.AtomicTest._

// 1.
trait Building
trait Room
trait Storage
trait Sink
trait Storable
trait Store[T <: Storable]
trait Cook[T]
trait Cleanable
trait Clean[T <: Cleanable]

trait Editable extends Storable with Cleanable

object EnumFood extends Enumeration {
  case class _Val() extends Val with Editable
  type EnumFood = _Val
  val Beef, Tomato, Potato = _Val()
}

trait Food[F <: Editable]
  extends Store[F]
  with Clean[F]
  with Cook[F]

trait Handheld extends Storable with Cleanable

object EnumCutlery extends Enumeration {
  case class _Val() extends Val with Handheld
  type EnumCutlery = _Val
  val poacher, timer, sifter, torch = _Val()
}

trait Utensil[H <: Handheld]
  extends Store[H]
  with Clean[H]
  with Cook[H]

trait Kitchen extends Room {
  val storage:Storage
  val sinks:Vector[Sink]
  val food:Food[Editable]
  val utensils:Vector[Utensil[Handheld]]
}

trait House extends Building {
  val kitchens:Vector[Kitchen]
}

case class MyHouse() extends House {
  override val kitchens = Vector[Kitchen]()
}

MyHouse is "MyHouse"

// 2.
class WithF {
  def f(n: Int) = n * 11
}

def callF[T <: WithF](t: T, n: Int) =
  t.f(n)

callF(new WithF, 2) is 22

callF(new WithF {
  override def f(n: Int) = n * 7
}, 2) is 14

// 3.
class Base {
  override def toString = "Base"
}

class Derived extends Base {
  override def toString = "Derived"
}

class Most extends Derived {
  override def toString = "Most"
}

def f1[T <: Base](t: T) =
  "f1: " + t.toString

def f2[T <: Derived](t: T) =
  "f2: " + t.toString

def f3[T <: Most](t: T) =
  "f3: " + t.toString

f1(new Base) is "f1: Base"
f1(new Derived) is "f1: Derived"
f1(new Most) is "f1: Most"

// error: inferred type arguments [this.Base] do not conform to method f2's type parameter bounds [T <: this.Derived]
//f2(new Base)
f2(new Derived) is "f2: Derived"
f2(new Most) is "f2: Most"

// error: inferred type arguments [this.Base] do not conform to method f3's type parameter bounds [T <: this.Most]
//f3(new Base)
// error: inferred type arguments [this.Derived] do not conform to method f3's type parameter bounds [T <: this.Most]
//f3(new Derived)
f3(new Most) is "f3: Most"
