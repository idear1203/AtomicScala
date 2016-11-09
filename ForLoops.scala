// ForLoops.scala

import com.atomicscala.AtomicTest._

// 1.
val r1 = Range(0, 10)
r1 is "Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)"

// 2.
val r2 = Range(0, 9).inclusive
r2 is "Range(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)"

// 3.
var total = 0
for (i <- Range(0, 10).inclusive) {
  total += i
}

total is 55

// 4.
var totalEvents = 0
for (number <- Range(0, 10).inclusive) {
  if (number % 2 == 0) {
    totalEvents += number
  }
}

totalEvents is 30

// 5.
var evens = 0
var odds = 0
for (number <- Range(0, 10).inclusive) {
  if (number % 2 == 0) {
    evens += number
  } else {
    odds += number
  }
}

evens is 30
odds is 25
(evens + odds) is 55

// 6.
evens = 0
odds = 0
for (number <- 0 to 10) {
  if (number % 2 == 0) {
    evens += number
  } else {
    odds += number
  }
}

evens is 30
odds is 25
(evens + odds) is 55
