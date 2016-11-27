package recfun

object Factorial {
  def factorial(n: Int): Int = {

    def factorialIt(count: Int, result: Int): Int = {
      if (count == n) result
      else factorialIt(count + 1, result * (count + 1))
    }

    factorialIt(1, 1)
  }

}
