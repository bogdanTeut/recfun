package recfun

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ProductSuite extends FunSuite {
  import Product.product
  import Product.factorial
  import Product.mapReduce

  test("product(2,1)") {
    assert(product(x => x * x)(2,1) === 1)
  }

  test("product(1,3)") {
    assert(product(x => x * x)(1,3) === 36)
  }

  test("factorial(5)") {
    assert(factorial(5) === 120)
  }

  test("mapReduce(cubes)(addition, 0)(1, 2)") {
    assert(mapReduce(x => x * x * x)((x, y) => x + y, 0)(1, 2) === 9)
  }

  test("mapReduce(cubes)(product, 1)(1, 3)") {
    assert(mapReduce(x => x * x * x)((x, y) => x * y, 1)(1, 3) === 216)
  }

}
