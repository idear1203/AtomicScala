// Fields.scala

import com.atomicscala.AtomicTest._

// 1.
class Cup2 {
  var percentFull = 0
  val max = 100
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    }
    percentFull // Return this value
  }
}

val cup = new Cup2
cup.add(50) is 50
cup.add(70) is 100

val cup2 = new Cup2
cup2.add(45) is 45
cup2.add(-15) is 30
cup2.add(-50) is -20

// 3.
class Cup3 {
  var percentFull = 0
  val max = 100
  val min = 0
  def add(increase:Int):Int = {
    percentFull += increase
    if(percentFull > max) {
      percentFull = max
    } else if (percentFull < min) {
        percentFull = min
    }
    percentFull // Return this value
  }
}

val cup3 = new Cup3
cup3.add(45) is 45
cup3.add(-55) is 0
cup3.add(10) is 10
cup3.add(-9) is 1
cup3.add(-2) is 0

// 3.
cup3.percentFull = 56
cup3.percentFull is 56

// 4.
class Cup4 {
  var percentFull = 0

  def get(): Int = {
    percentFull
  }

  def set(x: Int): Unit = {
    percentFull = x
  }
}

val cup4 = new Cup4
cup4.set(56)
cup4.get() is 56
