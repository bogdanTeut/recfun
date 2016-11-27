package recfun

object Sum {

  def id(x: Int): Int = x

  def cubes(x: Int): Int = x * x * x

  def factorial(x: Int): Int =
    if (x == 0) 1 else x * factorial(x - 1)

  //version one
  //  def sumInts(a: Int, b: Int): Int =
  //    if (a > b) 0
  //    else id(a) + sumInts(a+1, b)
  //
  //  def sumCubes(a: Int, b:Int): Int =
  //    if (a > b) 0
  //    else cubes(a) + sumCubes(a+1, b)
  //
  //  def sumFactorials(a: Int, b: Int): Int =
  //    if (a > b) 0
  //    else factorial(a) + sumFactorials(a+1, b)

  //version two
  def sum(f: Int => Int, a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sum(f, a + 1, b)

  //  def sumInts(a: Int, b: Int) = sum(id, a, b)
  //  def sumCubes(a: Int, b: Int) = sum(cubes, a, b)
  //  def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)

  //version three anonymous functions
//  def sumInts(a: Int, b: Int) = sum(x => x, a, b)
//
//  def sumCubes(a: Int, b: Int) = sum(x => x * x * x, a, b)
//
//  def sumFactorials(a: Int, b: Int) = sum(factorial, a, b)

  //version four recursive
  def sumRecursive(f: Int => Int, a: Int, b: Int): Int = {

    def loop(a: Int, acc: Int): Int =
      if (a > b) acc
      else loop(a + 1, acc + f(a))
      loop(a, 0)
  }

//  def sumInts(a: Int, b: Int) = sumRecursive(x => x, a, b)
//
//  def sumCubes(a: Int, b: Int) = sumRecursive(x => x * x * x, a, b)
//
//  def sumFactorials(a: Int, b: Int) = sumRecursive(factorial, a, b)

  //version five
  def sum(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int =
      if (a > b) 0
      else f(a) + sumF(a+1, b)
    sumF
  }

//  def sumInts = sum(x => x)
//
//  def sumCubes = sum(x => x * x * x)
//
//  def sumFactorials = sum(factorial)

  //version six currying
  def sumCurrying(f: Int => Int)(a: Int, b: Int): Int =
    if (a > b) 0
    else f(a) + sumCurrying(f)(a+1, b)

  def sumInts(a: Int, b: Int) = sumCurrying(x => x)(a, b)

  def sumCubes(a: Int, b: Int) = sumCurrying(x => x * x * x)(a, b)

  def sumFactorials(a: Int, b: Int) = sumCurrying(factorial)(a, b)



  def sumCubesF(f: Int => Int)(a: Int, b: Int) = sumCurrying(f)(a, b)

  def sumCubesG(a: Int, b: Int) = sumCurrying(x => x * x * x)(a, b)

}
