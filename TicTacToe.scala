// TicTacToe.scala
import com.atomicscala.AtomicTest._

class Cell {
  var entry = ' '

  def set(e: Char): String = {
    if (entry == ' ' && (e == 'X' || e == 'O')) {
      entry = e
      "successful move"
    } else
      "invalid move"
  }
}

class Grid {
  // define game state
  val tie = "Tie!";
  val goon = "Game goes on!";
  val xwin = "X wins!";
  val owin = "O wins!";

  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )

  def play(e: Char, x: Int, y: Int): String = {
    show
    var result = ""
    if (x < 0 || x > 2 || y < 0 || y > 2)
      result = "invalid move"
    else
      result = cells(x)(y).set(e)

    if (result == "successful move") {
      println(getGameState);
    }

    result
  }

  def show(): Unit = {
    cells foreach {
      row => row foreach {
        cell => {
          if (cell.entry == ' ') {
            print('.')
          } else {
            print(cell.entry)
          }
        }
      }

        println
    }
  }

  def getGameState(): String = {
    var blankCount = getBlankCount()
    val winner = getWinner()
    if (winner != '-') {
      if (winner == 'X') {
        xwin
      } else {
        owin
      }
    } else if (blankCount == 0) {
      tie
    } else {
      goon
    }
  }

  def getBlankCount(): Int = {
    var blankCount = 0
    cells foreach {
      row => row foreach {
        cell => {
          if (cell.entry == ' ') {
            blankCount += 1
          }
        }
      }
    }

    blankCount
  }

  def getWinner(): Char = {
    for (i <- 0 to 2) {
      if (cells(i)(0).entry != ' ' &&
        cells(i)(0).entry == cells(i)(1).entry &&
        cells(i)(1).entry == cells(i)(2).entry) {
        return cells(i)(0).entry
      } else if (cells(0)(i).entry != ' ' &&
        cells(0)(i).entry == cells(1)(i).entry &&
        cells(1)(i).entry == cells(2)(i).entry) {
        return cells(0)(i).entry
      }
    }

    if (cells(1)(1).entry != ' ' && ((cells(0)(0).entry == cells(1)(1).entry &&
      cells(1)(1).entry == cells(2)(2).entry) ||
      (cells(0)(2).entry == cells(1)(1).entry &&
        cells(1)(1).entry == cells(2)(0).entry))) {
      return cells(1)(1).entry
    }

    '-'
  }
}

val grid = new Grid
grid.play('X', 1, 1) is "successful move"
grid.play('X', 1, 1) is "invalid move"
grid.play('O', 1, 3) is "invalid move"
grid.play('O', 1, 0) is "successful move"
grid.play('X', 0, 1) is "successful move"
grid.play('O', 0, 0) is "successful move"
grid.play('X', 2, 1) is "successful move"
