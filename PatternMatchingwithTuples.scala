// PatternMatchingwithTuples.scala

import com.atomicscala.AtomicTest._

// 1. 2.
object Color extends Enumeration {
  type Color = Value
  val red, blue, yellow, purple,
    green, orange, brown, magenta, white = Value
}
import Color._

def blend(a: Color, b: Color) =
  (a, b) match {
    case _ if a == b => a
    //error: illegal variable in pattern alternative
    //case (red, blue) |
    case (`red`, `blue`) |
         (`blue`, `red`) => purple
    case (`red`, `yellow`) |
         (`yellow`, `red`) => orange
    case (`blue`, `yellow`) |
         (`yellow`, `blue`) => green
    case (`brown`, _) |
         (_, `brown`) => brown
    //case _ => // Interesting, not accurate:
         //Color((a.id + b.id) % Color.maxId)
  }

blend(red, yellow) is orange
blend(red, red) is red
blend(yellow, blue) is green

// 3.
def blend2(a: Color, b: Color) =
  (a, b) match {
    case _ if a == b => a
    case (`red`, `blue`) |
         (`blue`, `red`) => purple
    case (`red`, `yellow`) |
         (`yellow`, `red`) => orange
    case (`blue`, `yellow`) |
         (`yellow`, `blue`) => green
    case (`brown`, _) |
         (_, `brown`) => brown
    case (`magenta`, `red`) |
         (`red`, `magenta`) |
         (`magenta`, `yellow`) |
         (`yellow`, `magenta`) => purple
  }

blend2(red, yellow) is orange
blend2(red, red) is red
blend2(yellow,blue) is green
blend2(yellow, magenta) is purple
blend2(red, magenta) is purple

// 4.
def blend3(a: Color, b: Color) =
  (a, b) match {
    case _ if a == b => a
    //case (c1, c2) if c1 == white => c2
    //case (c1, c2) if c2 == white => c1
    case _ if a == white => b
    case _ if b == white => a
    case (`red`, `blue`) |
         (`blue`, `red`) => purple
    case (`red`, `yellow`) |
         (`yellow`, `red`) => orange
    case (`blue`, `yellow`) |
         (`yellow`, `blue`) => green
    case (`brown`, _) |
         (_, `brown`) => brown
    case (`magenta`, `red`) |
         (`red`, `magenta`) |
         (`magenta`, `yellow`) |
         (`yellow`, `magenta`) => purple
  }

blend3(red, yellow) is orange
blend3(red, red) is red
blend3(yellow,blue) is green
blend3(yellow, magenta) is purple
blend3(red, magenta) is purple
blend3(purple, white) is purple
blend3(white, red) is red
