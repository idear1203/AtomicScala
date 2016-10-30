// Traits.scala

import com.atomicscala.AtomicTest._

// 1.
trait BatteryPower {
  def monitor(power: Int): String = power match {
    case p if (p > 40) => "green"
    case p if (p >= 20) => "yellow"
    case _ => "red"
  }
}

class EnergySource 

class Battery extends EnergySource with BatteryPower
val battery = new Battery
battery.monitor(80) is "green"
battery.monitor(30) is "yellow"
battery.monitor(10) is "red"

// 2.
class Toy
class BatteryPoweredToy extends Toy with BatteryPower

val toy = new BatteryPoweredToy
toy.monitor(50) is "green"

// 3.
val toy2 = new Toy with BatteryPower
toy2.monitor(50) is "green"
