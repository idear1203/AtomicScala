// Brevity.scala

import com.atomicscala.AtomicTest._

// 1. 2. 3.
def assignResult(arg: Boolean) =
  if (arg) 42 else 47

assignResult(true) is 42
assignResult(false) is 47

class Coffee(val shots: Int = 2,
             val decaf: Boolean = false,
             val milk: Boolean = false,
             val toGo: Boolean = false,
             val syrup: String = "") {
  var result = ""
  println(shots, decaf, milk, toGo, syrup)

  def getCup() =
    if (toGo)
      result += "ToGoCup "
    else
      result += "HereCup "

  def pourShots() =
    for (s <- 0 until shots)
      if (decaf)
        result += "decaf shot "
      else
        result += "shot "

  def addMilk() =
    if (milk)
      result += "milk "

  def addSyrup() =
    result += syrup

  getCup()
  pourShots()
  addMilk()
  addSyrup()
}

val usual = new Coffee
usual.result is "HereCup shot shot "
val mocha = new Coffee(decaf = true,
  toGo = true, syrup = "Chocolate")
mocha.result is
  "ToGoCup decaf shot decaf shot Chocolate"
