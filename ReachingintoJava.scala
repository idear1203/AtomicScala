// ReachingintoJava.scala

import com.atomicscala.AtomicTest._

// 1.
import java.text.SimpleDateFormat

val datePattern = new SimpleDateFormat("MM/dd/yy")
val day = datePattern.parse("10/30/2016")
day.getDate is 30
day.getMonth is 9

// 2. mm represents minutes

// 3.  Months start with 0.  Days start with 1.  It's horribly inconsistent.

// 4. 5.
