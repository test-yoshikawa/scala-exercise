package scalableProgramming.chapter08

/**
 * @author Yuki Yoshikawa
 */
object FindLongLines {

	def main(args: Array[String]) {
		val width = args(0).toInt
		for(arg <- args.drop(1)) LongLines.processLines(arg, width)
	}
}