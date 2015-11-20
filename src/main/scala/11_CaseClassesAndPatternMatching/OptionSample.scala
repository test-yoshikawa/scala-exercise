package CaseClassesAndPatternMatching

/**
 * @author Yuki Yoshikawa
 */
object OptionSample {
	def main(args: Array[String]) {
		// Option型
		val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
		// getメソッドは引数のキーに対応する値があるときはSome(value)を返し、そうでない場合はNoneを返す
		val capital1 = capitals get "France"
		val capital2 = capitals get "America"
		println(capital1)
		println(capital2)
		println(show(capital1))
		println(show(capital2))
	}

	def show(x: Option[String]) = x match {
		case Some(s) => s
		case None => "?"
	}
}