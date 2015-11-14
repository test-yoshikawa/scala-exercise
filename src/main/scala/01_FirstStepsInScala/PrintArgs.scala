package FirstStepsInScala

/**
 * コマンドライン引数のwhileによる出力（改行あり）
 */
object PrintArgs {

	def main(args: Array[String]): Unit = {
		// 命令型スタイル
		var i = 0
		while (i < args.length) {
			println(args(i))
			i += 1
		}
	}
}