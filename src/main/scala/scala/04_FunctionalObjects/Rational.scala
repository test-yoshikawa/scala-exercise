package scala.FunctionalObjects

/**
 * 有理数（Rational Number）クラス
 */
class Rational(n: Int, d: Int) {
	// 事前条件( require(...) )falseの場合はIllegalArgumentExceptionをスローする
	require(d != 0)	// これより上の処理は実行される
	private val g = gcd(n.abs, d.abs)
	val number: Int = n / g
	val denom: Int = d / g
	def this(n: Int) = this(n, 1) // 補助コンストラクタ

	override def toString = number + "/" + denom

	/**
	 * 最大公約数を求める
	 *
	 */
	def gcd(a: Int, b: Int): Int =
		if (b == 0) a else gcd(b, a % b)

	/**
	 * 引数より小さいかどうか
	 *
	 */
	def lessThan(that: Rational) =
		this.number * that.denom < that.number * this.denom

	/**
	 * 引数より大きいかどうか判定する
	 */
	def max(that: Rational) =
		if (this.lessThan(that)) that else this

	/**
	 * 分数の加算
	 */
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
}