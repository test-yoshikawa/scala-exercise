package basic.nextstep

/**
 * タプル　サンプル
 */
object Tuples {
	def main(args: Array[String]) {
		// 異なる型の要素を持つことができる
		val pair = (99, "Luftballons")
		println(pair._1)
		println(pair._2)
	}
}