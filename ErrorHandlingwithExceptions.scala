//ErrorHandlingwithExceptions.scala

import com.atomicscala.AtomicTest._

// 1.
def test(which: Int) =
  try {
    which match {
      case 1 => throw new Exception(s"Bad number: $which")
      case _ => s"$which is okay"
    }
  } catch {
    case err:Exception => err.getMessage
  }

test(1) is "Bad number: 1"
test(0) is "0 is okay"

// 2.
class Solution2 {
  def f =
    "Call f"
}

def test2 =
  try{
    var sol2:Solution2 = null
    sol2.f
  } catch {
    case err:NullPointerException => "NullPointerException"
  }

test2 is "NullPointerException"

// 3.
def test3 = {
 try{
    var v = Vector("hello", "world")
    v(2)
  } catch {
    case err:IndexOutOfBoundsException => "IndexOutOfBoundsException"
  }
}

test3 is "IndexOutOfBoundsException"

// 4.
class MyIndexOutOfBoundsException(val msg: String)
  extends Exception(msg)

def test4 =
  try {
    throw new MyIndexOutOfBoundsException("MyIndexOutOfBoundsException")
  } catch {
    case err:MyIndexOutOfBoundsException => s"${err.msg}"
  }

test4 is "MyIndexOutOfBoundsException"

// 5.
class Exception1(val msg: String) extends Exception(msg)
class Exception2(val msg: String) extends Exception(msg)
class Exception3(val msg: String) extends Exception(msg)

def callee(num: Int) = num match {
  case 1 => throw new Exception1("throw Exception1")
  case 2 => throw new Exception2("throw Exception2")
  case 3 => throw new Exception3("throw Exception3")
  case _ => s"$num is okay"
}

def test5(num: Int) =
  try {
    callee(num)
  } catch {
    case err:Exception => err.getMessage
  }

test5(0) is "0 is okay"
test5(1) is "throw Exception1"
test5(2) is "throw Exception2"
test5(3) is "throw Exception3"

// 6.
class Solution6 {
  def g =
    throw new Exception1("throw Exception1 in g")

  def f =
    try{
      g
    } catch {
      case err:Exception1 => throw new Exception2(err.msg)
    }
}

def test6 = {
  try {
    val solution = new Solution6
    solution.f
  } catch {
    case err:Exception2 =>
      s"re-throw Exception2. Inner exception message: ${err.msg}"
  }
}

test6 is
  "re-throw Exception2. Inner exception message: throw Exception1 in g"

// 7.
class Base {
  throw new Exception1("Exception1 is thrown in Base")
}

class Derived extends Base {
  try {
    println("Initialize Derived")
  } catch {
    case err: Exception1 => s"Exception got in Derived. Message: ${err.msg}"
  }
}

def test7 = try {
  val derived = new Derived
} catch {
  case err: Exception1 => s"Exception got in test7. Message: ${err.msg}"
}

test7 is "Exception got in test7. Message: Exception1 is thrown in Base"

// 8.
class FailingConstructor {
  throw new Exception1("in constructor")
}

def test8 = {
  try{
    val o = new FailingConstructor
  } catch {
    case err: Exception1 => s"test8: ${err.msg}"
  }
}

test8 is "test8: in constructor"

// 9.
class ExceptionLevel1(val msg: String) extends Exception(msg)
class ExceptionLevel2(msg: String) extends ExceptionLevel1(msg)
class ExceptionLevel3(msg: String) extends ExceptionLevel2(msg)

class A {
  def f =
    throw new ExceptionLevel1("in A")
}

class B extends A{
  override def f =
    throw new ExceptionLevel2("in B")
}

class C extends B{
  override def f =
    throw new ExceptionLevel3("in C")
}

def test9 =
  try {
    val a:A = new C
    a.f
  } catch {
    case err:ExceptionLevel3 => s"test9: ${err.msg}"
  }

test9 is "test9: in C"

// 10.
class Solution10(num:Int) {
  var branch = ""
  def f =
    callee(num)
}

def test10(sol: Solution10) =
  try {
    sol.f
  } catch {
    case err:Exception => err.getMessage
  } finally {
    sol.branch = "finally"
  }

val sol0 = new Solution10(0)
test10(sol0) is "0 is okay"
sol0.branch is "finally"
val sol1 = new Solution10(1)
test10(sol1) is "throw Exception1"
sol1.branch is "finally"
val sol2 = new Solution10(2)
test10(sol2) is "throw Exception2"
sol2.branch is "finally"
val sol3 = new Solution10(3)
test10(sol3) is "throw Exception3"
sol3.branch is "finally"
