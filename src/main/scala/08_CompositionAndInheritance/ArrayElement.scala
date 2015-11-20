package CompositionAndInheritance

/**
 * レイアウト要素を扱う（配列版）
 */
class ArrayElement(val contents: Array[String]) extends ElementOld {
	// 不要な冗長性のあるコード⇒↑のようにパラメータフィールドとしてcontentsを定義する
	// パラメータにvalをつけた場合はパラメータとフィールドを同時に定義する略記法。クラス外からアクセスできる
	// val contents = conts

	// final修飾子を付けるとサブクラスでオーバーライドできなくなる
	// final override def demo() { …
	override def demo() {
		println("ArrayElement's implementation invoked")
	}
}