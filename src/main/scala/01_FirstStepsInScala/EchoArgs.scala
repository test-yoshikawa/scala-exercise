package FirstStepsInScala

/**
 * コマンドライン引数のwhileによる出力（改行なし）
 */
object EchoArgs {

	def main(args: Array[String]): Unit = {
		// 命令型スタイル
		var i = 0
		while (i < args.length) {
			if (i != 0) print(" ")
			print(args(i))
			i += 1
		}
		println()
	}
}