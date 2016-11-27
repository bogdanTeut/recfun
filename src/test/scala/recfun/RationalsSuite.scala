package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RationalsSuite extends FunSuite {

  import week3.rationals.testRationals

  test("testRationals") {
    assert(testRationals === "-79/42")
  }

}
