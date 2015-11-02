package scala.FunctionsAndClosures

import scala.io.Source

/**
 * @author Yuki Yoshikawa
 */
object LongLines {

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