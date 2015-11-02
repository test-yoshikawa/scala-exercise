package scala.NextStepsInScala

/**
 * @author Yuki Yoshikawa
 */
object greetStrings {
	def main(args: Array[String]): Unit = {
		val greetStrings = new Array[String](3)		// 作成・初期化する方法として推奨できない
		val numNames = Array("zero", "one", "two")	// 普段は←を使用するらしい
		
		greetStrings(0) = "Hello"
		greetStrings(1) = ", "
		greetStrings(2) =  "world!\n"

		for (i <- 0 to 2) print(greetStrings(i))

		for (name <- numNames) print(name + " ")

	}
}