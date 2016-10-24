// NamedAndDefaultArgs.scala

import com.atomicscala.AtomicTest._

// 1.
class SimpleTime(val hours: Int, val minutes: Int)

val t = new SimpleTime(hours = 5, minutes = 30)
t.hours is 5
t.minutes is 30

// 2.
class SimpleTime2(val hours: Int, val minutes: Int = 0)

val t2 = new SimpleTime2(hours = 10)
t2.hours is 10
t2.minutes is 0

// 3.
class Planet(name: String, description: String, moons: Int = 0) {
  def hasMoon: Boolean = {
    moons > 0
  }
}

val p = new Planet(name = "Mercury",
  description = "small and hot planet",
  moons = 0)
p.hasMoon is false

// 4.
val earth = new Planet(moons = 1,
  name = "Earth",
  description = "a hospitable planet")
earth.hasMoon is true

// 5. a parameter section with a `*'-parameter is not allowed to have default arguments

// 6.
class Item(name: String, price: Double) {
  def cost(grocery: Boolean = false,
           medication: Boolean = false,
           taxRate: Double = 0.1): Double = {
    if (grocery) {
      price
    } else {
      price + price * taxRate
    }
  }
}

val flour = new Item(name = "flour", 4)
flour.cost(grocery = true) is 4
val sunscreen = new Item(name = "sunscreen", 3)
sunscreen.cost() is 3.3
val tv = new Item(name = "television", 500)
tv.cost(taxRate = 0.06) is 530
