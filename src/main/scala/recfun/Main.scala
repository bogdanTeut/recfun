package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c == 0 || c == r) 1
      else pascal(c-1, r-1) + pascal(c, r-1)
    }

  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {

      def balancerCounter(head: Char, oldCounter: Int): Int =
        if (head == '(') oldCounter + 1
        else if (head == ')') oldCounter - 1
        else oldCounter

      def evaluate(chars: List[Char], counter: Int): List[Char] = {
        if (counter < 0) "not empty".toList
        else
          if (chars.tail.isEmpty)
            if (balancerCounter(chars.head, counter) == 0) "".toList
            else "not empty".toList
          else evaluate(chars.tail, balancerCounter(chars.head, counter))
      }

      val result = evaluate(chars, 0)

      result.isEmpty
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {

      def calculateIncrement(money: Int, coins: List[Int]): Int = {
        if (coins.isEmpty) 0
        else {
          val head = coins.head
          val divisor = money / head
          if (divisor > 0) {
            iterateThroughDivisorsAndCalculateIncrement(money, head, divisor, coins, 0)
          } else 0
        }
      }

      def calculateIncrementPerDivisor(money: Int, head: Int, divisor: Int, coins: List[Int]): Int = {
        val rest = money - head * divisor
        if (rest == 0) 1
        else if (coins.tail.isEmpty) 0
        else calculatorIt(rest, coins.tail, 0)
      }

    def iterateThroughDivisorsAndCalculateIncrement (money: Int, head: Int, divisor: Int, coins: List[Int], counter: Int): Int = {
      val increment = calculateIncrementPerDivisor (money, head, divisor, coins)
      if (divisor == 1) increment + counter
      else iterateThroughDivisorsAndCalculateIncrement(money, head, divisor-1, coins, increment + counter)
    }

      def calculatorIt (money: Int, coins: List[Int], counter: Int): Int = {
        if (coins.isEmpty) 0
        else {
          val increment = calculateIncrement(money, coins)
          if (coins.tail.isEmpty) {
            increment + counter
          }
          else calculatorIt(money, coins.tail, increment + counter)
        }
      }

    calculatorIt(money, coins, 0)
    }

  }
