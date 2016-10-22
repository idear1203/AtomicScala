// Overloading.scala

import com.atomicscala.AtomicTest._

// 1. error: method f is defined twice

// 2.

def f(): Int = { 0 }
def f(num1: Int): Int = { num1 }
def f(num1: Int, num2: Int): Int = { num1 + num2 }
def f(num1: Int, num2: Int, num3: Int): Int = { num1 + num2 + num3 }
def f(num1: Int, num2: Int, num3: Int, num4: Int): Int = { num1 + num2 + num3 + num4 }

f() is 0
f(1) is 1
f(1, 2) is 3
f(1, 2, 3) is 6
f(1, 2, 3, 4) is 10

// 3.
class NumberAdder {
    def f(): Int = { 0 }
    def f(num1: Int): Int = { num1 }
    def f(num1: Int, num2: Int): Int = { num1 + num2 }
    def f(num1: Int, num2: Int, num3: Int): Int = { num1 + num2 + num3 }
    def f(num1: Int, num2: Int, num3: Int, num4: Int): Int = { num1 + num2 + num3 + num4 }
}

val adder = new NumberAdder
adder.f() is 0
adder.f(1) is 1
adder.f(1, 2) is 3
adder.f(1, 2, 3) is 6
adder.f(1, 2, 3, 4) is 10

// 4.
// - 使用显式的返回类型：error: method f is defined twice
// - 对返回类型进行类型推断：error: method f is defined twice
