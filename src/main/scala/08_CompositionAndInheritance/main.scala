package scala.CompositionAndInheritance

/**
 * @author Yuki Yoshikawa
 */
object main {

	def main(args: Array[String]) = {
		// クラスの拡張
		val ae = new ArrayElement(Array("hello", "worlds"))
		println("ae.width = " + ae.width)
		println("ae.height = " + ae.height)

		// 多相性・動的束縛(ダイナミックバインディング)
		val le = new LineElement("scala")
		val ue = new UniformElement('x', 2, 3)
		invokeDemo(ae)
		invokeDemo(le)
		invokeDemo(ue) // demo()をオーバーライドをしていないためスーパークラスのdemo()の実装を継承

		// above, beside, toStringの実装
		println("==== above, beside, toStringの実装 ====")
		val ae2 = new ArrayElement(Array(" yoshikawa", "!"))
		println("<aboveメソッド　結果>")
		val aeAbove = ae.above(ae2)
		println(aeAbove)
		println("<besideメソッド　結果>")
		val aeBeside = ae.beside(ae2)
		println(aeBeside)

		println("==== 実装クラスの隠ぺい(シングルトンオブジェクトを定義) ====")
		val ae3 = Element.elem(Array("ArrayElementSingleton", "TEST"))
		println(ae3)
		val le2 = Element.elem("LineElementSingleton")
		println(le2)
		val ue2 = Element.elem('x', 10, 10)
		println(ue2)


	}

	def invokeDemo(e: ElementOld) {
		e.demo()
	}
}