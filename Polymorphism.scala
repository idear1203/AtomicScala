// Polymorphism.scala

import com.atomicscala.AtomicTest._

// 1.
trait Mobile {
  def move: String =
    "move!"
}

class Animal extends Mobile {
  override def move: String =
    s"Animal ${super.move}"
}

class Vehicle extends Mobile {
  override def move: String =
    s"Vehicle ${super.move}"
}

def move(mobile: Mobile) = {
  mobile.move
}

move(new Animal) is "Animal move!"
move(new Vehicle) is "Vehicle move!"

// 2.
class Element {
  def draw =
    "Drawing the element"
}

class Inert extends Element {
  override def draw =
    "Inert drawing!"
}

class Wall extends Inert

val e = new Element
e.draw is "Drawing the element"
val in = new Inert
in.draw is "Inert drawing!"
val wall = new Wall
wall.draw is "Inert drawing!"

// 3.
class CleanWall extends Inert {
  override def draw =
    "Don't draw on the wall!"
}

val cleanWall = new CleanWall
cleanWall.draw is "Don't draw on the wall!"

// 4.
class Character(val player: String = "None") extends Element
class Dragon(player: String) extends Character(player)
val d = new Dragon("Puff")
d.player is "Puff"

// 5.
abstract class Seed

class Tomato extends Seed {
  override def toString =
    "Tomato"
}

class Corn extends Seed {
  override def toString =
    "Corn"
}

class Zucchini extends Seed {
  override def toString =
    "Zucchini"
}

class Garden(seeds: Seed*) {
  val plants = seeds.toVector
  override def toString =
    plants.mkString(", ")
}

val garden = new Garden(new Tomato, new Corn, new Zucchini)
garden is "Tomato, Corn, Zucchini"

// 6.
trait Shape {
  def draw: String
  //override def toString =
    //draw
}

class Ellipse extends Shape {
  override def draw: String =
    "Ellipse"
}

class Circle extends Ellipse {
  override def draw: String =
    "Circle"
}

class Rectangle extends Shape {
  override def draw: String =
    "Rectangle"
}

class Square extends Rectangle {
  override def draw: String =
    "Square"
}

class Drawing(shapes: Shape*) {
  val _shapes = shapes.toVector
  def draw =
    for { shape <- _shapes } yield shape.draw
  override def toString =
    draw.mkString(", ")
}

val drawing = new Drawing(
  new Rectangle, new Square,
  new Ellipse, new Circle)
drawing.draw is "Vector(Rectangle," +
  " Square, Ellipse, Circle)"
drawing is "Rectangle, Square," +
  " Ellipse, Circle"
