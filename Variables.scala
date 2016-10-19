// Variables.scala

// 1.
val a: Int = 5
println(a)

// error: reassignment to val
// a = 10

// 2.
var v1: Int = 5
v1 = 10
val constantv1 = v1
println(v1)
println(constantv1)

// 3.
// Change v1 does not effect value of constantv1
v1 = 15
println(v1)
println(constantv1)

// 4.
var v2: Int = v1
// Change v1 does not effect value of v2
v1 = 20
println(v1)
println(v2)
