package FunctionalObjects

/**
 * 有理数　実行用サンプル
 */
object Main {

	def main(args: Array[String]): Unit = {

		//=======================
		// Rational
		//=======================
		println("\n-- Initalize Rational --")
		val oneHalf = new Rational(1, 2)
		println(oneHalf)
		val twoThirds = new Rational(2, 3)
		println(twoThirds)

		println("\n-- Rational add ( add method ) --")
		print(oneHalf + " + " + twoThirds + " = ")
		println(oneHalf add twoThirds)

		println("\n-- size determination --")
		print(oneHalf + " < " + twoThirds + " : ")
		println(oneHalf.lessThan(twoThirds))

		println("\n-- Required condition --")
		try {
			print("5/0 : ")
			val invalidValue = new Rational(5, 0)
		} catch {
			// 事前条件を満たない場合
			case e: IllegalArgumentException => println("IllegalArgumentException") 
		}
		println("\n-- reduction --")
		val three = new Rational(3)
		println("3 / 1 = " + three)
		println("66 / 42 = " + new Rational(66, 42))

		println("\n-- add ( + method) --")
		println("1/2 + 2/3 = " +  oneHalf.+(twoThirds))
		println("\n-- multiple --")
		println("1/2 * 2/3 = " + oneHalf.*(twoThirds))

		// 暗黙の型変換の設定
		implicit def intToRational(x: Int) = new Rational(x)
		println("2 * 1/2 = " +  2 * oneHalf)
		println("\n-- multiple --")
		println("1/2 < 2/3 => " + (oneHalf < twoThirds))
	}
}
