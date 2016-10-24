// DefiningOperators.scala

import com.atomicscala.AtomicTest._

// 1.
class SimpleTime2(val hours: Int, val minutes: Int) {
  def -(other: SimpleTime2) = {
    val difference = getValue() - other.getValue()
    if (difference > 0) {
      new SimpleTime2(difference / 60, difference % 60)
    } else {
      new SimpleTime2(0, 0)
    }
  }

  def getValue() = {
    hours * 60 + minutes
  }
}

val someT1 = new SimpleTime2(10, 30)
val someT2 = new SimpleTime2(9, 30)
val someST = someT1 - someT2
someST.hours is 1
someST.minutes is 0

val someST2 = new SimpleTime2(10, 30) - new SimpleTime2(9, 45)
someST2.hours is 0
someST2.minutes is 45

// 2.
class FancyNumber1(base :Int) {
  def power(n :Int) =
    math.pow(base, n)
}

val a1 = new FancyNumber1(2)
a1.power(3) is 8
val b1 = new FancyNumber1(10)
b1.power(2) is 100

// 3.
class FancyNumber2(base :Int) {
  def ^(n :Int) =
    math.pow(base, n)
}

val a2 = new FancyNumber2(2)
a2.^(3) is 8
val b2 = new FancyNumber2(10)
b2 ^ 2 is 100

// 4.
class FancyNumber3(base :Int) {
  def power(n :Int) =
    math.pow(base, n)
  def ^(n :Int) =
    power(n)
  def **(n :Int) =
    power(n)
}

val a3 = new FancyNumber3(2)
a3.^(3) is 8
a3.**(3) is 8
val b3 = new FancyNumber3(10)
b3 ^ 2 is 100
b3 ** 2 is 100
