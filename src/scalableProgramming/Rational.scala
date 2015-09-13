package scalableProgramming

/**
 * @author Yuki Yoshikawa
 */
class Rational(n: Int, d: Int) {
	// 事前条件falseの場合はIllegalArgumentExceptionをスローする
	// これより上の処理は実行される
	require(d != 0)
	private val g = gcd(n.abs, d.abs)
	val number: Int = n / g
	val denom: Int = d / g
	println("Constructor " + n + "/" + d)
	def this(n: Int) = this(n, 1) // 補助コンストラクタ

	override def toString = number + "/" + denom

	def add(that: Rational): Rational =
		new Rational(number * that.denom + that.number + denom, denom * that.denom)

	def + (i:Int): Rational =
		new Rational(number + i * denom, denom)

	def + (that: Rational): Rational =
		new Rational(number * that.denom + that.number + denom, denom * that.denom)

	def - (i:Int): Rational =
		new Rational(number - i * denom, denom)

	def - (that: Rational): Rational =
		new Rational(number * that.number, denom * that.denom)

	def * (that: Rational): Rational =
		new Rational(number * that.number, denom *  that.denom)

	def * (i: Int): Rational =
		new Rational(number * i, denom)

	def / (that: Rational): Rational =
		new Rational(number * that.denom, denom * that.number)

	/**
	 * 引数のRationalより小さいかどうか
	 *
	 */
	def lessThan(that: Rational) =
		this.number * that.denom < that.number * this.denom

	def max(that: Rational) =
		if (this.lessThan(that)) that else this

	/**
	 * 最大公約数を求める
	 *
	 */
	def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b)
}