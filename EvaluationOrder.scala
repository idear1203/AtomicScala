// EvaluationOrder.scala
val sunny = true
val partlyCloudy = false
val hoursSleep = 6
val exercise = false
val temp = 55

// 1.
val happy1 = sunny && temp > 80
println(happy1) //false

// 2.
val happy2 = (sunny || partlyCloudy) &&
    temp > 80
println(happy2) //false

// 3.
val happy3 = (sunny || partlyCloudy) &&
    (temp > 80 || temp < 20)
println(happy2) //false

// 4.
val celsius = (temp - 32) * 5.0 / 9
println(celsius)

// 5.
val fahrenheit = celsius * 9.0 / 5 + 32
println(fahrenheit)
