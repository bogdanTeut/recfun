package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FactorialSuite extends FunSuite {
  import Factorial.factorial

  test("factorial(2)") {
      assert(factorial(2) === 2)
  }

  test("factorial(3)") {
      assert(factorial(3) === 6)
  }

  test("factorial(4)") {
      assert(factorial(4) === 24)
  }

  test("factorial(5)") {
    assert(factorial(5) === 120)
  }

  test("factorial(6)") {
    assert(factorial(6) === 720)
  }
}
