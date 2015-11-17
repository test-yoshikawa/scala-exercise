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
		println("-- Rational add ( add method ) --")
		print(oneHalf + " + " + twoThirds + " = ")
		println(oneHalf add twoThirds)
		println()
		println("-- size determination --")
		print(oneHalf + " < " + twoThirds + " : ")
		println(oneHalf.lessThan(twoThirds))
		println()
		println("-- Required condition --")
		try {
			print("5/0 : ")
			val invalidValue = new Rational(5, 0)
		} catch {
			// 事前条件を満たない場合
			case e: IllegalArgumentException => println("IllegalArgumentException") 
		}
		println()
		println("-- reduction --")
		val three = new Rational(3)
		println("3 / 1 = " + three)
		println("66 / 42 = " + new Rational(66, 42))

		println()
		println("-- add ( + method) --")
		println("1/2 + 2/3 = " +  oneHalf.+(twoThirds))
		println()
		println("-- multiple --")
		println("1/2 * 2/3 = " + oneHalf.*(twoThirds))
		println()
		// 暗黙の型変換の設定
		implicit def intToRational(x: Int) = new Rational(x)
		println("2 * 1/2 = " +  2 * oneHalf)
	}
}
