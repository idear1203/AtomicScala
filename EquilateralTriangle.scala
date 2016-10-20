// EquilateralTriangle.scala

//2.
//pacakge com.atomicscala.shape

class EquilateralTriangle {
    def area(side: Double): Double = {
        math.sqrt(3) / 4.0 * side * side
    }
}

val equilateralTriangle = new EquilateralTriangle
val area = equilateralTriangle.area(2)
println(area)
assert(math.sqrt(3) == area,
    "Expected  1.7320508075688772, Got " + area)
