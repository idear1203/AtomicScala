// MapAndReduces.scala

import com.atomicscala.AtomicTest._

// 1.
val v = Vector(1, 2, 3, 4)
v.map(_ * 11 + 10) is
  Vector(21, 32, 43, 54)

// 2.
v.foreach(_ * 11 + 10) is
  ()

// 3. 4. 5.

// 6.
def sumIt(nums: Int*) = {
  nums.reduce((sum, x) => sum + x)
}

sumIt(1, 2, 3) is 6
sumIt(45, 45, 45, 60) is 195
