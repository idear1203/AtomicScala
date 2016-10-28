// AbstractClasses.scala

import com.atomicscala.AtomicTest._

// 1.
abstract class Animal {
  def templateMethod =
    s"The $animal goes $sound"
    // Abstract methods (no method body):
  def animal: String
  def sound: String
  def food: String
}

// Error -- abstract class
// cannot be instantiated:
// val a = new Animal

class Duck extends Animal {
  def animal = "Duck"
    // "override" is optional here:
    override def sound = "Quack"
    def food = "plants"
}

class Cow extends Animal {
  def animal = "Cow"
  def sound = "Moo"
  def food = "grass"
}

val duck = new Duck
duck.food is "plants"
val cow = new Cow
cow.food is "grass"

// 2.
class Chicken extends Animal {
  def animal = "Chicken"
  def sound = "Jiji"
  def food = "insects"
}

class Pig extends Animal {
  def animal = "Pig"
  def sound = "HengHeng"
  def food = "anything"
}

val chicken = new Chicken
chicken.food is "insects"
val pig = new Pig
pig.food is "anything"

// 3.
abstract class Adder(x: Int) {
  def add(y: Int): Int
}

class NumericAdder(val x:Int) extends Adder(x) {
    def add(y:Int):Int = x + y
}

val num = new NumericAdder(5)
num.add(10) is 15
