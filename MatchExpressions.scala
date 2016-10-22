// MatchExpressions.scala

import com.atomicscala.AtomicTest._

// 1.
def matchColor(color: String): String = {
    if (color == "red") {
        "RED"
    } else if (color == "blue") {
        "BLUE"
    } else if (color == "green") {
        "GREEN"
    } else {
        "UNKNOWN COLOR: " + color
    }
}

matchColor("white") is
    "UNKNOWN COLOR: white"
matchColor("blue") is
    "BLUE"

// 2.
def oneOrTheOther(exp:Boolean):String = {
    exp match {
        case true => "True!"
        case _ => "It's false"
    }
}

val v = Vector(1)
val v2 = Vector(3, 4)
oneOrTheOther(v == v.reverse) is "True!"
oneOrTheOther(v2 == v2.reverse) is
"It's false"

// 3.
def checkTruth(exp1:Boolean, exp2:Boolean):String = {
    (exp1, exp2) match {
        case (exp1, exp2) if exp1 && exp2 => "Both are true"
        case (exp1, exp2) if !exp1 && !exp2 => "Both are false"
        case (exp1, exp2) if exp1 => "First: true, second: false"
        case  _ => "First: false, second: true"
    }
}

checkTruth(true || false, true) is
  "Both are true"
checkTruth(1 > 0 && -1 < 0, 1 == 2) is
  "First: true, second: false"
checkTruth(1 >= 2, 1 >= 1) is
  "First: false, second: true"
checkTruth(true && false,false && true) is
"Both are false"

// 4.
def forecast(extent: Int): String = {
    extent match {
        case 100 => "Sunny"
        case 80 => "Mostly Sunny"
        case 50 => "Partly Cloudy"
        case 20 => "Mostly Cloudy"
        case 0 => "Cloudy"
        case _ => "Unknown"
    }
}

forecast(100) is "Sunny"
forecast(80) is "Mostly Sunny"
forecast(50) is "Partly Cloudy"
forecast(20) is "Mostly Cloudy"
forecast(0) is "Cloudy"
forecast(15) is "Unknown"

// 5.
val sunnyData = Vector(100, 80, 50, 20, 0, 15)
val expected = Vector("Sunny", "Mostly Sunny", "Partly Cloudy", "Mostly Cloudy", "Cloudy", "Unknown");
for (i <- Range(0, sunnyData.length)) {
    forecast(sunnyData(i)) is expected(i)
}
