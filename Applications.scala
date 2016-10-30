// Applications.scala

import com.atomicscala.AtomicTest._

// 1.

// 2.
trait BatteryPower {
  def monitor(power: Int): String = power match {
    case p if (p > 40) => "green"
    case p if (p >= 20) => "yellow"
    case _ => "red"
  }
}

class EnergySource 

class Battery extends EnergySource with BatteryPower

object Battery extends App {
  val battery = new Battery
  battery.monitor(80) is "green"
  battery.monitor(30) is "yellow"
  battery.monitor(10) is "red"
}

// 3.
class Battery2 extends EnergySource with BatteryPower

object Battery2 extends App {
  val battery = new Battery
  args.foreach(arg => println(battery.monitor(arg.toInt)))
}
