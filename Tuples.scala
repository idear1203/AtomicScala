// Tuples.scala

import com.atomicscala.AtomicTest._

// 1.
val tuple1 = (65, "Sunny", "Stars")
val (temp1, sky1, view1) = tuple1
temp1 is 65
sky1 is "Sunny"
view1 is "Stars"

val tuple2 = (78, "Cloudy", "Satellites")
val (temp2, sky2, view2) = tuple2
temp2 is 78
sky2 is "Cloudy"
view2 is "Satellites"

val tuple3 = (51, "Blue", "Night")
val (temp3, sky3, view3) = tuple3
temp3 is 51
sky3 is "Blue"
view3 is "Night"

// 2.
val info = (50, 45)
info._1 is 50
info._2 is 45

// 3.
def weather(temperature: Int, humidity: Int) = {
  (getTemperatureDesp(temperature),  getHumidityDesp(temperature, humidity))
}

def getTemperatureDesp(temperature: Int) = {
  temperature match {
    case t if t > 80 => "Hot"
    case t if t < 50 => "Cold"
    case _ => "Temperate"
  }
}

def getHumidityDesp(temperature: Int, humidity: Int) = {
  if (humidity > 40){
    if (temperature < 50)
      "Damp"
    else
      "Humid"
  } else {
    "Plesant"
  }
}

weather(81, 45) is ("Hot", "Humid")
weather(50, 45) is ("Temperate", "Humid")

// 4.
val (heat1, moisture1) = weather(81, 45)
heat1 is "Hot"
moisture1 is "Humid"
val (heat2, moisture2) = weather(27, 55)
heat2 is "Cold"
moisture2 is "Damp"
