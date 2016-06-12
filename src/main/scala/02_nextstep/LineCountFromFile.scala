package basic.nextstep

import scala.io.Source

/**
 * ファイルから行を読み出す
 * Windowsでの実行の場合はsbt/sbtconfig.txtに「-Dfile.encoding=UTF-8」を追加
 * ⇒実行は成功するがコンソールは文字化けする
 */
object LineCountFromFile {

	def main(args: Array[String]) {
		val filename = "./src/main/scala/basic/02_nextstep/LineCountFromFile.scala"
		for (line <- Source.fromFile(filename).getLines()) {
			println(line.length + " " + line)
		}
		println()
		println()

		val lines = Source.fromFile(filename).getLines().toList	// getLines()はイテレーターを返すのでListに変換する必要がある
		// 各行の最大文字数を取得する
		// List(1, 2, 3).reduceLeft(f) => f(f(1, 2), 3)の結果
		var longestLine = lines.reduceLeft((a, b) => if (a.length > b.length) a else b)
		// longestLineの文字数を取得する
		val maxWidth = widthOfLength(longestLine)
		for (line <- lines) {
			val numSpace = maxWidth - widthOfLength(line)
			val padding = " " * numSpace
			println(padding + line.length + " | " + line)
		}
	}

	/**
	 * 引数の長さを何文字で表示できるかを取得（ex.文字数113⇒3文字）
	 */
	def widthOfLength(s: String) = s.length.toString.length
}