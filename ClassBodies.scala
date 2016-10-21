// ClassBodies.scala

package com.atomicscala.exercise

class NoBody {
  def className = {
    this.getClass.getSimpleName
  }
}

class SomeBody {
  val name = "Janet Doe"
  println(name + " is SomeBody")
  def className = {
    this.getClass.getSimpleName
  }
}

class EveryBody {
  val all = Vector(new SomeBody,
    new SomeBody, new SomeBody)
  def className = {
    this.getClass.getSimpleName
  }
}
