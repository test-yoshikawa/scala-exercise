package NextStepsInScala

/**
 * 配列の操作
 */
object GreetStrings {

	def main(args: Array[String]): Unit = {
		val greetStrings = new Array[String](3)		// 作成・初期化する方法として推奨できない
		val numNames = Array("zero", "one", "two")	// 普段は←を使用するらしい
		
		greetStrings(0) = "Hello"
		greetStrings.update(1, ",")	// 実行する際はこのコードに書き換えられる
		greetStrings(2) =  "world!\n"

		for (i <- 0 to 2) print(greetStrings(i))

		for (name <- numNames) print(name + " ")

	}
}