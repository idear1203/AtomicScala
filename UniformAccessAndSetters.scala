// UniformAccessAndSetters.scala

import com.atomicscala.AtomicTest._

// 1.
abstract class Base {
  def f1: Int
  def f2: Int
  val d1: Int
  val d2: Int
  var d3: Int
  var n = 1
}

class Derived extends Base {
  def f1 = 1
  val f2 = 1 // Was def, now val
  val d1 = 1
  // Can't do this; must be a val:
  // def d2 = 1
  val d2 = 1
  def d3 = n
  def d3_=(newVal:Int) = n = newVal
}

val d = new Derived
d.d3 is 1
d.d3 = 42
d.d3 is 42
d.n is 42

// 2
class Base2(var d3: Int) {
  def f1: Int = 99
  def f2: Int = 99
  val d1: Int = 99
  val d2: Int = 99
  var n = 1
}

class Derived2(d3: Int) extends Base2(d3) {
  override def f1 = 1
  override val f2 = 1 // Was def, now val
  override val d1 = 1
  // Can't do this; must be a val:
  // def d2 = 1
  override val d2 = 1
}

val d2 = new Derived2(1)
d2.d3 is 1
d2.d3 = 42
d2.d3 is 42

// 3.
class Interval {
  var interval = 1
  def x = interval
  def x_= (interval: Int) =
    this.interval = interval
}

val i1 = new Interval
i1.x is 1
i1.x = 2
i1.x is 2
i1.interval is 2
