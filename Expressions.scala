// Expressions.scala

// 1.
val feetPerMile: Double = 5280

// 2.
val yardsPerMile: Double = feetPerMile / 3.0

// 3.
val milesFor2000Yards: Double = 2000 / yardsPerMile
println(milesFor2000Yards)

// 4.
val milesFor2000Yards2: Double = {
    val feetPerMile: Double = 5280
    val yardsPerMile: Double = feetPerMile / 3.0
    2000 / yardsPerMile
}
println(milesFor2000Yards2)
