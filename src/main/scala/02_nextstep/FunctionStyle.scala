package nextstep

/**
 * 関数型スタイル　サンプル
 */
object FunctionStyle {
	def main(args: Array[String]) {
		// 命令型のスタイル
		println("nOutput in the imperative style(命令型)")
		printArgs(args)

		// 関数的なスタイル（純粋な関数型ではない）
		println("\nOutput in the function style (side effects)")
		printArgsFunctionStyle1(args)

		// 関数型のスタイル
		println("\nOutput in the function style (no side effects)")
		val res = printArgsFunctionStyle2(args)
		println(res)
		val compare = "next, step, in, scala"
		try {
			assert(res == compare)
		} catch {
			case e:AssertionError => println("java.lang.AssertionError expected: [" + compare + "] actual: [" + res + "]")
		}
	}

	/**
	 * 引数の要素をすべて出力（命令型スタイル）
	 */
	def printArgs(args: Array[String]): Unit = {
		var i = 0
		while (i < args.length) {
			print(args(i))
			i += 1
		}
	}

	/**
	 * 引数の要素をすべて出力（関数的なスタイル）
	 */
	def printArgsFunctionStyle1(args: Array[String]): Unit = {
		args.foreach(print)
	}

	/**
	 * 引数の要素をすべて出力（関数型のスタイル）
	 */
	def printArgsFunctionStyle2(args: Array[String]) = args.mkString(", ")
}