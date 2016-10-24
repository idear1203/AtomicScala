// ABitOfStyle.scala

import com.atomicscala.AtomicTest._

// 1.

class Exclaim(var s: String) {
  def noParents = s + "!"
  def parents() = s + "!"
}
val e = new Exclaim("yes")
e.noParents is "yes!"
e.parents() is "yes!"

// 2.
class Exclaim2(val s: String) {
  def noParents = s + "!"
  def parents() = s + "!"
}
val e2 = new Exclaim2("yes")
e2.noParents is "yes!"
e2.parents() is "yes!"

// 3.
class Exclaim3(var s: String) {
  def noParents = s + "!"
}
val e3 = new Exclaim3("yes")
e3.noParents is "yes!"

// 4.
class Exclaim4(var s: String) {
  var count = 0
  def exclaim() = {
    count += 1
    s + "!"
  }
}
val e4 = new Exclaim4("counting")
e4.exclaim() is "counting!"
e4.exclaim() is "counting!"
e4.count is 2

