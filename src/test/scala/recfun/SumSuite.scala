package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SumSuite extends FunSuite {
  import Sum.sumInts
  import Sum.sumCubes
  import Sum.sumFactorials

  test("sumInts(2, 1)") {
    assert(sumInts(2, 1) === 0)
  }

  test("sumInts(1, 2)") {
    assert(sumInts(1, 2) === 3)
  }

  test("sumCubes(2, 1)") {
    assert(sumCubes(2, 1) === 0)
  }

  test("sumCubes(1, 2)") {
    assert(sumCubes(1, 2) === 9)
  }

  test("sumFactorials(2, 1)") {
    assert(sumFactorials(2, 1) === 0)
  }

  test("sumFactorials(1, 3)") {
    assert(sumFactorials(1, 3) === 9)
  }
}
