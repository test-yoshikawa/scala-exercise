package basic.functionsandclosures

/**
 * <一般的な関数定義方法>
 * ファイルの内容を取得して、指定した行より長い行を出力する
 * Windowsでの実行の場合はsbt/sbtconfig.txtに「-Dfile.encoding=UTF-8」を追加
 * ⇒実行は成功するがコンソールは文字化けする
 * 【実行例】
 * sbt "run-main basic.functionsandclosures.FindLongLines 10 ./src/main/scala/basic/05_buildincontrol/Matchs.scala"
 */
object FindLongLines {
	def main(args: Array[String]) {
		val width = args(0).toInt
		for(arg <- args.drop(1)) LongLines.processLines(arg, width)
	}
}