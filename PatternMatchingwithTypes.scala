// PatternMatchingwithTypes.scala

import com.atomicscala.AtomicTest._

// 1.
case class Person(name: String)

def plus1(x: Any): Any = {
  x match {
    case str: String => s"${str}s"
    case num: Int => num + 1
    case p: Person => s"$p + guest"
    case _ => "What the hell is it?"
  }
}
plus1("car") is "cars"
plus1(67) is 68
plus1(Person("Joanna")) is
  "Person(Joanna) + guest"

// 2.
def convertToSize(x: Any): Any = {
  x match {
    case str: String => str.length
    case _: Int | _: Double | _: Float => x
    case _: Person => 1
    case _ => 0
  }
}

convertToSize(45) is 45
convertToSize("car") is 3
convertToSize("truck") is 5
convertToSize(Person("Joanna")) is 1
convertToSize(45.6F) is 45.6F
convertToSize(Vector(1, 2, 3)) is 0

// 3.
def convertToSize2(x: Any): Int = {
  x match {
    case str: String => str.length
    case n: Int => n
    case f: Float => math.round(f)
    case _: Person => 1
    case _ => 0
  }
}

convertToSize2(45) is 45
convertToSize2("car") is 3
convertToSize2("truck") is 5
convertToSize2(Person("Joanna")) is 1
convertToSize2(45.6F) is 46
convertToSize2(Vector(1, 2, 3)) is 0

// 4.
def quantify(x: Any): String = {
  x match {
    case i: Int if (i < 100) => "small"
    case i: Int if (i <= 1000) => "medium"
    case i: Int => "large"
    case d: Double if (d < 100) => "small"
    case d: Double if (d <= 1000) => "medium"
    case d: Double => "large"
    case _ => "Unknown"
  }
}

quantify(100) is "medium"
quantify(20.56) is "small"
quantify(100000) is "large"
quantify(-15999) is "small"

// 5.
def forecast(percentage: Int): String = {
  percentage match {
    case p if (p < 0 || p > 100) => "Unknown"
    case p if (p == 0) => "Cloudy"
    case p if (p <= 20) => "Mostly Cloudy"
    case p if (p <= 50) => "Partly Sunny"
    case p if (p <= 80) => "Mostly Sunny"
    case p if (p <= 100) => "Sunny"
    case _ => "Unknown"
  }
}

forecast(100) is "Sunny"
forecast(81) is "Sunny"
forecast(80) is "Mostly Sunny"
forecast(51) is "Mostly Sunny"
forecast(50) is "Partly Sunny"
forecast(21) is "Partly Sunny"
forecast(20) is "Mostly Cloudy"
forecast(1) is "Mostly Cloudy"
forecast(0) is "Cloudy"
forecast(-1) is "Unknown"
