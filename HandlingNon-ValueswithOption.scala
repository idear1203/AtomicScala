// HandlingNon-ValueswithOption.scala

import com.atomicscala.AtomicTest._

// 1. 2.
def f(i: Int): Option[Int] =
  if(i == 0)
    None
  else
    Some(24 / i)

f(4) is Some(6)
f(5) is Some(4)
f(6) is Some(4)
f(0) is None
f(24) is Some(1)
f(25) is Some(0)

// 3.
class Cell {
  var entry = ' '
  def set(e: Char) = {
    if(entry==' ' && (e=='X' || e=='O')) {
      entry = e
      Some("successful move")
    } else
      None
  }
}

class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )
  def play(e: Char, x: Int, y: Int) = {
    if(x < 0 || x > 2 || y < 0 || y > 2)
      None
    else
      cells(x)(y).set(e)
  }
}

val grid = new Grid
grid.play('X', 1, 1) is Some("successful move")
grid.play('X', 1, 1) is None
grid.play('O', 1, 3) is None

// 4.
def alphanumeric(x: Int) =
  if ((0 <= x && x <= 9) || Character.isLetter(x))
    Some(x)
  else
    None

alphanumeric(0) is Some(0)
alphanumeric('a') is Some('a')
alphanumeric('m') is Some('m')
alphanumeric('$') is None
alphanumeric('Z') is Some('Z')
