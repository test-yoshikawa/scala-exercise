package abstractmembers

/** Rational Trait */
trait RationalTrait {
  val numerArg: Int
  val denomArg: Int

  require(denomArg != 0)
  println("Constructor " + numerArg + "/" + denomArg)

  private val g = gcd(numerArg, denomArg)
  val numer: Int = numerArg / g
  val denom: Int = denomArg / g

  /** 最大公約数を求める
    *
    * @param a Int
    * @param b Int
    * @return 最大公約数
    */
  def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = numer + "/" + denom
}