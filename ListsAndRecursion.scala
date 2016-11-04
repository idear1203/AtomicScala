// ListAndRecursion.scala

// 1.
import com.atomicscala.AtomicTest._

def max(aList: List[Int]): Int = {
  if (aList.tail.nonEmpty) {
    math.max(aList.head, max(aList.tail))
  } else {
    aList.head
  }
}

val aList = List(10, 20, 45, 15, 30)
max(aList) is 45

// 2.

// 3.
def sumIt(toSum: List[Int]): Int =
  toSum.reduce((x, y) => (x + y))

sumIt(List(1, 2, 3)) is 6
sumIt(List(45, 45, 45, 60)) is 195

// 4.
def calcFreq(animalList: List[String], animal: String, total: Int = 0): Int =
  if (animalList.isEmpty) {
    total
  } else if (animalList.head == animal) {
    calcFreq(animalList.tail, animal, total + 1)
  } else {
    calcFreq(animalList.tail, animal, total)
  }

var animalList = List("cat", "dog", "cat", "bird", "cat",
  "cat", "kitten", "mouse")
calcFreq(animalList, "cat") is 4
calcFreq(animalList, "dog") is 1
