package basic.ControlAbstraction

/**
 * API実行用
 *
 */
object Main {

	def main(args: Array[String]) {
		/**
		 * ファイル検索API
		 */
		val filesEnding = FileMatcher.filesEnding("scala")
		println("==== File ending match result ====")
		filesEnding.toList.foreach(println _)
		val filesContaining  =FileMatcher.filesContaining("Matcher")

		println("\n==== File contain match result ====")
		filesContaining.toList.foreach(println _)

		println("\n==== File create ====")
		val file = new java.io.File("./src/main/scala/07_ControlAbstraction/data.txt")
		FileMatcher.withPrintWriter(file) {
			writer => writer.println(new java.util.Date())
		}


		/**
		 * List検索API
		 */
		val test = List(0, -1, 2, 3, 4)
		println("\n==== List contain negative number result ====")
		println(ListMatcher.containsNegByFunction(test))

	}
}