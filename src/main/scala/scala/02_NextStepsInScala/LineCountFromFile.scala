package scala.NextStepsInScala

import scala.io.Source

/**
 * ファイルから行を読み出す
 * Windowsでの実行の場合はsbt/sbtconfig.txtに「-Dfile.encoding=UTF-8」を追加
 * ⇒実行は成功するがコンソールは文字化けする
 */
object LineCountFromFile {

	def main(args: Array[String]): Unit = {
		// val filename = "C:\\pleiades\\workspace\\scala-excercise\\src\\scalableProgramming\\chapter03\\countchars1.scala"
		val filename = "./src/main/scala/scala/02_NextStepsInScala/LineCountFromFile.scala"
		for (line <- Source.fromFile(filename).getLines()) {
			println(line.length + " " + line)
		}
		println()
		println()

		val lines = Source.fromFile(filename).getLines().toList
		// 各行の最大文字数を取得する
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
	 * 引数の長さを何文字で表示できるかを取得（ex.113文字⇒3文字）
	 */
	def widthOfLength(s: String) = s.length.toString.length
}