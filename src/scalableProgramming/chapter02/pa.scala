package scalableProgramming.chapter02

/**
 * @author Yuki Yoshikawa
 */
object pa {
	def main(args: Array[String]): Unit = {

		println("---- args.foreach(arg => println(arg)) ----")
		args.foreach(arg => println(arg))
		println()
		println("---- args.foreach((arg: String) => println(arg)) ----")
		args.foreach((arg: String) => println(arg))
		println()
		println("---- args.foreach(println) ----")
		args.foreach(println)
	}
}