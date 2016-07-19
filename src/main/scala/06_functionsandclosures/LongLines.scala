package functionsandclosures

import scala.io.Source

/**
 * ファイルの行に関するオブジェクト
 */
object LongLines {
	/**
	 * 指定された行の長さより長い行を出力する
	 */
	def processLines(filename: String, width: Int) {
		def pricessLine(line: String) {
			if (line.length > width) println(filename + ": " + line.trim)
		}

		val source = Source.fromFile(filename)
		for (line <- source.getLines()) {
			pricessLine(line)
		}
	}
}