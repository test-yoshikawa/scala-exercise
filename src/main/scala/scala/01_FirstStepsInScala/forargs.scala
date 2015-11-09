package scala.FirstStepsInScala

/**
 * コマンドライン引数のForとForeachによる出力
 */
object ForArgs {
	def main(args: Array[String]): Unit  = {
		println("---- for (arg <- args) println(arg) ----")
		for (arg <- args) println(arg)
		println()

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