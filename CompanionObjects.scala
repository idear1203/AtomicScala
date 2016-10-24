// CompanionObjects.scala

import com.atomicscala.AtomicTest._

// 1.
class WalkActivity

object WalkActivity {
  def start(name: String) =
    s"$name started!"
}

WalkActivity.start("Johnny") is "Johnny started!"

// 2.
class WalkActivity2

object WalkActivity2 {
  var log = ""

  def start(name: String) = {
    s"$name started!"
    log += s"[$name] Activity started."
  }

  def stop(name: String) = {
    s"$name stopped!"
    log += s"[$name] Activity stopped."
  }
}

WalkActivity2.start("Jane")
WalkActivity2.stop("Jane")
WalkActivity2.start("John")
WalkActivity2.log is "[Jane] Activity started.[Jane] Activity stopped.[John] Activity started."

// 3.
class WalkActivity3 {
def calories(lbs:Int, mins:Int, mph:Double=3):Long =
  math.round((WalkActivity3.MET * 3.5 * lbs * 0.45)/200.0 * mins)
}

object WalkActivity3 {
  val MET = 2.3
  var log = ""

  def start(name: String) = {
    s"$name started!"
    log += s"[$name] Activity started."
  }

  def stop(name: String) = {
    s"$name stopped!"
    log += s"[$name] Activity stopped."
  }
}

val sally = new WalkActivity3
sally.calories(150, 30) is 82

// 4.
class WalkActivity4 {
def calories(lbs:Int, mins:Int, mph:Double=3):Long =
  math.round((WalkActivity4.MET(mph) * 3.5 * lbs * 0.45)/200.0 * mins)
}

object WalkActivity4 {
  var log = ""
  
  def start(name: String) = {
    s"$name started!"
    log += s"[$name] Activity started."
  }

  def stop(name: String) = {
    s"$name stopped!"
    log += s"[$name] Activity stopped."
  }

  def MET(mph:Double) = mph match {
    case x if(x < 1.7) => 2.3
    case x if(x < 2.5) => 2.9
    case x if(x < 3) => 3.3
    case x if(x >= 3) => 3.3
    case _ => 2.3
  }
}

WalkActivity4.MET(1.0) is 2.3
WalkActivity4.MET(2.7) is 3.3

val suzie = new WalkActivity4
suzie.calories(150, 30) is 117
val john = new WalkActivity4
john.calories(150, 30, 1.5) is 82
