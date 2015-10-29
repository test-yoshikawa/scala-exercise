package scalableProgramming.chapter02

/**
 * @author Yuki Yoshikawa
 */
object forargs {
	def main(args: Array[String]): Unit  = {
		for (arg <- args) println(arg)
	}
}