// ParameterizedTypes.scala

import com.atomicscala.AtomicTest._

// 1.
def explicitDouble(d1: Double, d2: Double, d3: Double): Vector[Double] = {
  Vector(d1, d2, d3)
}
explicitDouble(1.0, 2.0, 3.0) is Vector(1.0, 2.0, 3.0)

// 2.
def explicitList(v: Vector[Any]): List[Any] = {
  v.toList
}
explicitList(Vector(10.0, 20.0)) is
  List(10.0, 20.0)
explicitList(Vector(1, 2, 3)) is
  List(1, 2, 3)

// 3.
def explicitSet(v: Vector[Any]): Set[Any] = {
  v.toSet
}
explicitSet(Vector(10.0, 20.0, 10.0)) is
  Set(10.0, 20.0)
explicitSet(Vector(1, 2, 3, 2, 3, 4)) is
  Set(1, 2, 3, 4)

// 4.
def forecast(extent: Int): String = {
  extent match {
    case 100 => "Sunny"
    case 80 => "Mostly Sunny"
    case 50 => "Partly Cloudy"
    case 20 => "Mostly Cloudy"
    case 0 => "Cloudy"
    case _ => "Unknown"
  }
}

// TODO: generalization
def historicalData(weather: Vector[Int]): String = {
  var sunnyCount = 0
  var mostlySunnyCount = 0
  var mostlyCloudyCount = 0
  weather.foreach(
    _ match {
      case 100 => sunnyCount += 1
      case 80 => mostlySunnyCount += 1
      case 20 => mostlyCloudyCount += 1
    })
  s"Sunny=$sunnyCount, Mostly Sunny=$mostlySunnyCount, Mostly Cloudy=$mostlyCloudyCount"
}

val weather = Vector(100, 80, 20, 100, 20)
historicalData(weather) is
  "Sunny=2, Mostly Sunny=1, Mostly Cloudy=2"
