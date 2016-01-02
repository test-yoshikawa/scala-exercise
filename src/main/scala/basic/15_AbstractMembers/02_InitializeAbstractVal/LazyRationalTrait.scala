package basic.AbstractMembers

trait LazyRationalTrait {
	val numerArg: Int
	val denomArg: Int

	println("Constructor " + numerArg + "/" + denomArg)

	private lazy val g = {
		require(denomArg != 0)
		gcd(numerArg, denomArg)
	}
	lazy val numer: Int = numerArg / g
	lazy val denom: Int = denomArg / g

	/**
	 * 最大公約数を求める
	 *
	 */
	def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b)

	override def toString = numer + "/" + denom

}