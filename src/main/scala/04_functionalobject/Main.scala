package functionalobject

/**
 * 有理数　実行用サンプル
 */
object Main {
	def main(args: Array[String]) {
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

		// 暗黙の型変換の設定(warningが発生する)
		// warningが発生するのは以下の理由のため
		// ・implicit conversion の過剰な使用は多くの落とし穴を作ることになる
		// ・implicit conversion はとても強力だし、その効果が理解しやすいので、過剰に使われやすい。
		// ・implicit parameter を使ったほうが implicit conversion を使うよりも多くの場面で良い設計になる。
		// あまり使いすぎないようにする
		import scala.language.implicitConversions	// warningが発生しないようにimport
		implicit def intToRational(x: Int) = new Rational(x)
		println("2 * 1/2 = " +  2 * oneHalf)
		println("\n-- multiple --")
		println("1/2 < 2/3 => " + (oneHalf < twoThirds))
	}
}
