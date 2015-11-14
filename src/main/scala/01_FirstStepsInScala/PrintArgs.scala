package FirstStepsInScala

/**
 * コマンドライン引数のwhileによる出力（改行あり）
 */
object PrintArgs {
	def main(args: Array[String]): Unit = {
		var i = 0
		while (i < args.length) {
			println(args(i))
			i += 1
		}
	}
}