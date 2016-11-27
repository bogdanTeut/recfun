object rationals{

  val x = new Rational(1, 5)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)
  println(x.sub(y).sub(z))

}
class Rational(x: Int, y: Int) {
  def numer = x
  def denom = y

  def add(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def neg: Rational = {
    new Rational (
      -1 * numer,
      denom
    )
  }

  def mul(multiplier: Int): Rational = {
    new Rational (
      multiplier * numer,
      denom
    )
  }

  def sub(that: Rational): Rational = add(that.neg)

  override def toString: String = {
    numer + "/" + denom
  }
}