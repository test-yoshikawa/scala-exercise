package scalableProgramming.chapter10

/**
 * @author Yuki Yoshikawa
 */
class ArrayElement(val contents: Array[String]) extends ElementOld {
	// 不要な冗長性のあるコード⇒↑のようにパラメータフィールドとしてcontentsを定義する
	//	def contents: Array[String] = conts

	// final修飾子を付けるとサブクラスでオーバーライドできなくなる
	// final override def demo() { …
	override def demo() {
		println("ArrayElement's implementation invoked")
	}
}