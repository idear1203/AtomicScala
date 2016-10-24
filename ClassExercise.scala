// ClassExercise.scala

import com.atomicscala.AtomicTest._

// 1.
class Dimension(var height: Int, var width: Int)

val c = new Dimension(5, 7)
c.height is 5
c.height = 10
c.height is 10
c.width = 19
c.width is 19

// 2.
class Info(val name: String, var description: String)

val info = new Info("stuff", "Something")
info.name is "stuff"
info.description is "Something"
info.description = "Something else"
info.description is "Something else"

// 3.
class Info2(var name: String, var description: String)

val info2 = new Info2("stuff", "Something")
info2.name is "stuff"
info2.description is "Something"
info2.description = "Something else"
info2.description is "Something else"
info2.name = "This is the new name"
info2.name is "This is the new name"

// 4.
class SimpleTime(val hours: Int, val minutes: Int) {
  def substract(other: SimpleTime): SimpleTime = {
    val difference = getValue() - other.getValue()
    if (difference > 0) {
      new SimpleTime(difference / 60, difference % 60)
    } else {
      new SimpleTime(0, 0)
    }
  }

  def getValue(): Int = {
    hours * 60 + minutes
  }
}

val t1 = new SimpleTime(10, 30)
val t2 = new SimpleTime(9, 30)
val st = t1.substract(t2)
st.hours is 1
st.minutes is 0
val st2 = new SimpleTime(10, 30).
  substract(new SimpleTime(9, 45))
st2.hours is 0
st2.minutes is 45
val st3 = new SimpleTime(9, 30).
  substract(new SimpleTime(10, 0))
st3.hours is 0
st3.minutes is 0

// 5.
class SimpleTimeDefault(val hours: Int, val minutes: Int = 0) {
  def substract(other: SimpleTimeDefault): SimpleTimeDefault = {
    val difference = getValue() - other.getValue()
    if (difference > 0) {
      new SimpleTimeDefault(difference / 60, difference % 60)
    } else {
      new SimpleTimeDefault(0)
    }
  }

  def getValue(): Int = {
    hours * 60 + minutes
  }
}

val anotherT1 = new SimpleTimeDefault(10, 30)
val anotherT2 = new SimpleTimeDefault(9)
val anotherST = anotherT1.substract(anotherT2)
anotherST.hours is 1
anotherST.minutes is 30
val anotherST2 = new SimpleTimeDefault(10).
  substract(new SimpleTimeDefault(9, 45))
anotherST2.hours is 0
anotherST2.minutes is 15

// 6.
class SimpleTimeAux(val hours: Int, val minutes: Int) {
  def this(hours: Int) = {
    this(hours, 0)
  }

  def substract(other: SimpleTimeAux): SimpleTimeAux = {
    val difference = getValue() - other.getValue()
    if (difference > 0) {
      new SimpleTimeAux(difference / 60, difference % 60)
    } else {
      new SimpleTimeAux(0)
    }
  }

  def getValue(): Int = {
    hours * 60 + minutes
  }
}

val auxT1 = new SimpleTimeAux(10, 5)
val auxT2 = new SimpleTimeAux(6)
val auxST = auxT1.substract(auxT2)
auxST.hours is 4
auxST.minutes is 5
val auxST2 = new SimpleTimeAux(12).
  substract(new SimpleTimeAux(9, 45))
auxST2.hours is 2
auxST2.minutes is 15

// 7.
