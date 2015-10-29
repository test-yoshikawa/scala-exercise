package scalableProgramming.chapter03

/**
 * @author Yuki Yoshikawa
 */
object functionStyleSample {

	def main(args: Array[String]):Unit = {
		// 命令型のスタイル
		println("命令型で出力")
		printArgs(args)

		// 関数的なスタイル
		println("\n関数型で出力：副作用（標準出力）あり")
		printArgsFunctionStyle1(args)

		// 関数型のスタイル
		println("\n関数型で出力：副作用なし")
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