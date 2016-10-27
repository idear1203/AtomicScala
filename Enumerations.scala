// Enumerations.scala

import com.atomicscala.AtomicTest._

// 1.
object MonthName extends Enumeration {
  type MonthName = Value
  val January,
      February,
      Match,
      April,
      May,
      June,
      July,
      August,
      September,
      October,
      November,
      December = Value
}

MonthName.February is "February"
MonthName.February.id is 1

// 2.
object MonthName2 extends Enumeration {
  type MonthName2 = Value
  val January = Value(1)
  val February,
      Match,
      April,
      May,
      June,
      July,
      August,
      September,
      October,
      November,
      December = Value
}

MonthName2.February is "February"
MonthName2.February.id is 2
MonthName2.December.id is 12
MonthName2.July.id is 7

// 3.
import MonthName2._

def monthNumber(monthName: MonthName2) =
  monthName.id

July is "July"
monthNumber(July) is 7

// 4.
def season(monthName: MonthName2) = monthName match {
  case December | January | February => "Winter"
  case Match | April | May => "Spring"
  case June | July | August => "Summer"
  case September | October | November => "Autumn"
  case _ => "Unknown season"
}

season(January) is "Winter"
season(April) is "Spring"
season(August) is "Summer"
season(November) is "Autumn"

// 5.
