package basic.NextStepsInScala

/**
 * 関数型スタイル　サンプル
 */
object FunctionStyleSample {

	def main(args: Array[String]):Unit = {
		// 命令型のスタイル
		println("nOutput in the imperative style")
		printArgs(args)

		// 関数的なスタイル
		println("\nOutput in the function style (side effects)")
		printArgsFunctionStyle1(args)

		// 関数型のスタイル
		println("\nOutput in the function style (no side effects)")
		val res = printArgsFunctionStyle2(args)
		println(res)
		assert(res == "yo, shi, ka, wa, yu, u, ki")

	}

	def printArgs(args: Array[String]): Unit = {
		var i = 0
		while (i < args.length) {
			print(args(i))
			i += 1
		}
	}

	def printArgsFunctionStyle1(args: Array[String]): Unit = {
		args.foreach(print)
	}

	def printArgsFunctionStyle2(args: Array[String]) = args.mkString(", ")
}