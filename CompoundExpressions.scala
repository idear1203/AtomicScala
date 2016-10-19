// CompoundExpressions.scala

var a: Int = 1
var b: Int= 5

// 1.
val c: Int = 5
if (a <= c) {
    println("a is not more than c")
} else {
    println("a is more than c")
}

if (b <= c) {
    println("b is not more than c")
} else {
    println("b is more than c")
}

// 2.
a = 1; b = 5;
if (a <= c && b <= c) {
    println("both are!")
} else if (a <= c || b <= c) {
    println("one is and one is not!")
} else {
    println("none is!")
}

// 3.
val activity = "swimming"
val hour = 5
val lowestTemperature = 10
val highestTemperature = 30
val temperature = 5

val isOpen = {
    if (activity == "swimming" ||
        activity == "ice skating") {
        val opens = 9
        val closes = 20
        println("Operating hours:" +
            opens + " - " + closes)
        (hour >= opens && hour <= closes)
    } else {
        false
    }
}

val goodTemperature = {
    println("Temperature range: " + lowestTemperature +
        " - " + highestTemperature);
    (temperature >= lowestTemperature &&
        temperature <= highestTemperature)
}

val doActivity = isOpen && goodTemperature
println(activity + ": " + isOpen + " && " +
    goodTemperature + " = " + doActivity)

// 4.
