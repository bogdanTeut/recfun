package week3

object rationals{

  def testRationals: String = {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    val z = new Rational(3, 2)

    x + y
    x < y
    (x - y - z).toString
  }


}
class Rational(x: Int, y: Int) {
  require(y != 0, "demonimator must be nonzero")
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(a, a % b)
  private val g = gcd(x, y)
  def numer = x / g
  def denom = y / g

  def < (that: Rational) = this.numer * that.denom < this.denom * that.numer

  def max(that: Rational) = if (this < that) that else this

  def + (that: Rational): Rational = {
    new Rational(
      this.numer * that.denom + that.numer * this.denom,
      denom * that.denom
    )
  }

  def unary_- : Rational =
    new Rational (-numer, denom)


  def mul(multiplier: Int): Rational = {
    new Rational (
      multiplier * numer,
      denom
    )
  }

  def - (that: Rational): Rational = this + -that

  override def toString: String = {
    numer + "/" + denom
  }
}
