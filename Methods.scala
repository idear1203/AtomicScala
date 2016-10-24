// Methods.scala

// 1.
def getSquare(x: Int): Int = {
  x * x
}

var expected1 = 0;
val a = getSquare(3)
expected1 = 9;
assert(expected1 == a, "expected " + expected1 +
  " Got " + a);

val b = getSquare(6)
expected1 = 36;
assert(expected1 == b, "Expected " + expected1 +
  " Got " + b);

val c = getSquare(5)
expected1 = 25;
assert(expected1 == c, "Expected " + expected1 +
  " Got " + c);

// 2.
def getSquareDouble(x: Double): Double = {
  x * x
}

var expected2 = 0.0;
val sd1 = getSquareDouble(1.2)
expected2 = 1.44
assert(expected2 == sd1, "Expected " + expected2 +
  " Got " + sd1);
val sd2 = getSquareDouble(5.7)
expected2 = 32.49
assert(expected2 == sd2, "Expected " + expected2 +
  " Got " + sd2);

// 3.
def isArg1GreaterThanArg2(arg1: Double, arg2: Double): Boolean = {
  if (arg1 > arg2) {
    true
  } else {
    false
  }
}

val t1 = isArg1GreaterThanArg2(4.1, 4.12);
assert(false == t1, "Expected " + false +
  " Got " + t1);
val t2 = isArg1GreaterThanArg2(2.1, 1.2);
assert(true == t2, "Expected " + true +
  " Got " + t2);

// 4.
def getMe(str: String): String = {
  str.toLowerCase()
}

val g1 = getMe("abraCaDabra")
var expected4 = "abracadabra";
assert(expected4 == g1, "Expected " + expected4 +
  " Got " + g1);
val g2 = getMe("zyxwVUT")
expected4 = "zyxwvut";
assert(expected4 == g2, "Expected " + expected4 +
  " Got " + g2);

// 5.
def addStrings(str1: String, str2: String): String = {
  str1 + str2
}

val s1 = addStrings("abc", "def")
var expected5 = "abcdef"
assert(expected5 == s1, "Expected " + expected5 +
  " Got " + s1);
val s2 = addStrings("zyx", "abc")
expected5 = "zyxabc"
assert(expected5 == s2, "Expected " + expected5 +
  " Got " + s2);

// 6.
def manyTimesString(str: String, times: Int): String = {
  if (times <= 1) {
    str
  } else {
    str + manyTimesString(str, times - 1)
  }
}

val m1 = manyTimesString("abc", 3)
var expected6 = "abcabcabc"
assert(expected6 == m1, "Expected " + expected6 +
  " Got " + m1);
val m2 = manyTimesString("123", 2)
expected6 = "123123"
assert(expected6 == m2, "Expected " + expected6 +
  " Got " + m2);

// 7.
