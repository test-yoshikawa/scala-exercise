package firststep

/**
 * コマンドライン引数のwhileによる出力（改行あり）
 */
object PrintArgs {
	def main(args: Array[String]) {
		// 命令型スタイル（改行あり）
		var i = 0
		while (i < args.length) {
			println(args(i))
			i += 1
		}

		// 命令型スタイル（改行なし）
		println()
		i = 0
		while (i < args.length) {
			if (i != 0) print(" ")
			print(args(i))
			i += 1
		}
		println()
	}
}