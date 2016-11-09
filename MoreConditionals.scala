// MoreConditionals.scala

import com.atomicscala.AtomicTest._

// 1.
// when the vector is palindromic
val v = Vector(1, 2, 3, 2, 1)
v is v.reverse

// 2.
def isPalindrome(s: String): Boolean = {
  s != null && s.reverse == s
}

isPalindrome(null) is false
isPalindrome("mom") is true
isPalindrome("dad") is true
isPalindrome("street") is false

// 3.
def isPalIgnoreCase(s: String): Boolean = {
  s != null && s.equalsIgnoreCase(s.reverse)
}

isPalIgnoreCase("Bob") is true
isPalIgnoreCase("DAD") is true
isPalIgnoreCase("Blob") is false

// 4.
def isPalIgnoreSpecial(str: String): Boolean = {
  if (str != null) {
    var createdStr = ""
    for (c <- str) {
      //Convert to Int for comparison:
      val theValue = c.toInt
      if (('A' <= theValue && theValue <= 'Z') || ('a' <= theValue && theValue <= 'z')) {
        createdStr += c
      } else if ('0' <= theValue && theValue <= '9') {
        createdStr += c
      }
    }

    isPalIgnoreCase(createdStr)
  } else {
    false
  }
}

isPalIgnoreSpecial("Madam I'm adam") is true
