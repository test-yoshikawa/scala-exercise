package scalableProgramming.chapter02

/**
 * @author Yuki Yoshikawa
 */
object printargs {
	def main(args: Array[String]): Unit = {
		var i = 0
		while (i < args.length) {
			println(args(i))
			i += 1
		}
	}
}