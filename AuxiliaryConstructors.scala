// AuxiliaryConstructors.scala

import com.atomicscala.AtomicTest._

// 1.
class ClothesWasher(model: String, capacity: Double) {
  def this() = {
    this("LG 100", 1.0)
  }

  def this(model: String) = {
    this(model, 1.0)
  }

  def this(capacity: Double) = {
    this("LG 100", capacity)
  }

  def show(): String = {
    model + ", " + capacity
  }
}

new ClothesWasher("model1", 3.0).show() is "model1, 3.0"
new ClothesWasher("model1").show() is "model1, 1.0"
new ClothesWasher(3.0).show() is "LG 100, 3.0"
new ClothesWasher().show() is "LG 100, 1.0"

// 2.
class ClothesWasher2(model: String = "LG 100", capacity: Double = 1.0) {
  def show(): String = {
    model + ", " + capacity
  }
}

new ClothesWasher2(model = "model1", capacity = 3.0).show() is "model1, 3.0"
new ClothesWasher2(model = "model1").show() is "model1, 1.0"
new ClothesWasher2(capacity = 3.0).show() is "LG 100, 3.0"
new ClothesWasher2().show() is "LG 100, 1.0"

// 3. error: 'this' expected but identifier found.

// 4.
class ClothesWasher3(model: String, capacity: Double) {
  def this() = {
    this("LG 100", 1.0)
  }

  def this(model: String) = {
    this(model, 1.0)
  }

  def this(capacity: Double) = {
    this("LG 100", capacity)
  }

  def show(): String = {
    model + ", " + capacity
  }

  def wash(bleach: Int, fabric: Int): String = {
    "Wash used %d bleach and %d fabric softener".format(bleach, fabric)
  }

  def wash(): String = {
    "Simple wash"
  }
}

val washer = new ClothesWasher3("LG 100", 3.6)
washer.wash(2, 1) is
  "Wash used 2 bleach and 1 fabric softener"
washer.wash() is "Simple wash"
