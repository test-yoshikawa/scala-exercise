package scala.FunctionalObjects

/**
 * @author Yuki Yoshikawa
 */
object Main {

	def main(args: Array[String]): Unit = {

		//=======================
		// Rational
		//=======================
		val oneHalf = new Rational(1, 2)
		println(oneHalf)

		val twoThirds = new Rational(2, 3)
		println(twoThirds)

		println()
		println("-- 加算(addメソッド) --")
		println(oneHalf add twoThirds)
		println()
		println("-- 大小判定 --")
		println(oneHalf.lessThan(twoThirds))

		// 実行エラー：IllegalArgumentException
		// val invalidValue = new Rational(5, 0)
		// println(invalidValue)

		println()
		println("-- 約分 --")
		val three = new Rational(3)
		println(three)
		println(new Rational(66, 42))

		println()
		println("-- 加算(+メソッド) --")
		println(oneHalf.+(twoThirds))
		println()
		println("-- 乗算 --")
		println(oneHalf.*(twoThirds))
		println("-- 乗算 --")
		// 暗黙の型変換の設定
		implicit def intToRational(x: Int) = new Rational(x)
		println(2 * oneHalf)

	}
}
