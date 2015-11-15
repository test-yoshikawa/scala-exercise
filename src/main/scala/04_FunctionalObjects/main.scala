package FunctionalObjects

/**
 * 有理数　実行用サンプル
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
		print(oneHalf + " + " + twoThirds + " = ")
		println(oneHalf add twoThirds)
		println()
		println("-- 大小判定 --")
		print(oneHalf + " < " + twoThirds + " : ")
		println(oneHalf.lessThan(twoThirds))
		println()
		println("-- 事前条件 --")
		try {
			print("5/0 : ")
			val invalidValue = new Rational(5, 0)
		} catch {
			// 事前条件を満たない場合
			case e: IllegalArgumentException => println("IllegalArgumentException") 
		}
		println()
		println("-- 約分 --")
		val three = new Rational(3)
		println("3 / 1 = " + three)
		println("66 / 42 = " + new Rational(66, 42))

		println()
		println("-- 加算(+メソッド) --")
		println("1/2 + 2/3 = " +  oneHalf.+(twoThirds))
		println()
		println("-- 乗算 --")
		println("1/2 * 2/3 = " + oneHalf.*(twoThirds))
		println()
		println("-- 乗算 --")
		// 暗黙の型変換の設定
		implicit def intToRational(x: Int) = new Rational(x)
		println("2 * 1/2 = " +  2 * oneHalf)
	}
}
