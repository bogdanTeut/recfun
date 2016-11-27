package recfun

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: example given in instructions") {
    assert(countChange(4,List(1,2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }

  test("only tenner") {
    assert(countChange(10,List(10)) === 1)
  }

  test("not enough") {
    assert(countChange(10,List(20)) === 0)
  }

  test("30$") {
    assert(countChange(30,List(20,10)) === 2)
  }

  test("50CHF") {
    assert(countChange(50,List(10,20,50)) === 4)
  }

  test("80@") {
    assert(countChange(80,List(10,20,50)) === 7)
  }

  test("90LEI") {
    assert(countChange(90,List(10,20,50)) === 8)
  }

  test("100bitcoins") {
    assert(countChange(100,List(10,20,50)) === 10)
  }

  test("noCoins") {
    assert(countChange(25,List()) === 0)
  }
}
