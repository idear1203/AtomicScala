// ALittleReflection.scala

import com.atomicscala.AtomicTest._
import com.atomicscala.Name

// 1.
case class Person(name: String)
val p = Person("Aaron")
p is "Person(Aaron)"

case class Person1(name: String) extends Name
val p1 = Person1("Aaron")
p1 is "Person1"

// 2.
class Person2(name: String) extends Name
val p2 = new Person2("Aaron")
p2 is "Person2"

// 3.

// 4.
trait AllAbstract {
  def f(n:Int):Int
  val d:Double
}

trait PartialAbstract {
  def f(n:Int):Int
  val d:Double
  def g(s:String) = s"($s)"
  val j = 42
}

trait Concrete {
  def f(n:Int) = n * 11
  val d = 1.61803
}

val x = new AllAbstract with
  PartialAbstract with Concrete with Name
x is "anno"
