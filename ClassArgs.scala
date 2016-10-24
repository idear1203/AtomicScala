// ClassArgs.scala

import com.atomicscala.AtomicTest._

// 1.
class Family(names: String*) {
  def familySize(): Int = {
    names.length
  }
}

val family1 = new Family("Mom", "Dad", "Sally", "Dick")
family1.familySize() is 4
val family2 = new Family("Dad", "Mom", "Harry")
family2.familySize() is 3

// 2.
class FlexibleFamily(dad: String, mom: String, kids: String*) {
  def familySize(): Int = {
    var count = 0;
    if (dad != null) {
      count += 1
    }

    if (mom != null) {
      count += 1
    }

    count + kids.length
  }
}

val family3 = new FlexibleFamily("Mom", "Dad", "Sally", "Dick")
family1.familySize() is 4
val family4 = new FlexibleFamily("Dad", "Mom", "Harry")
family2.familySize() is 3

// 3.
val familyNoKids = new FlexibleFamily("Mom", "Dad");
familyNoKids.familySize() is 2

// 4. 5. error: *-parameter must come last

// 6.
class Cup4(var percentFull: Int) {
  val max = 100

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    percentFull // Return this value
  }
}

val cup4 = new Cup4(0)
cup4.add(50) is 50
cup4.add(70) is 100

// 7.
cup4.percentFull is 100
cup4.percentFull = 10
cup4.percentFull is 10

// 8.
class Cup5(var percentFull: Int) {
  val max = 100

  def add(increase: Int): Int = {
    percentFull += increase
    if (percentFull > max) {
      percentFull = max
    }
    percentFull // Return this value
  }

  def increase(numbers: Int*): Int = {
    numbers.foreach(add(_))
    percentFull
  }
}

val cup5 = new Cup5(0)
cup5.increase(20, 30, 50, 20, 10, -10, -40, 10, 50) is 100
cup5.increase(10, 10, -10, 10, 90, 70, -70) is 30

// 9.
def squareThem(nums: Int*): Int = {
  nums.map(x => x * x).sum
}

squareThem(2) is 4
squareThem(2, 4) is 20
squareThem(1, 2, 4) is 21
