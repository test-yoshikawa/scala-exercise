package basic.CompositionAndInheritance

/**
 * 2Dレイアウト要素を構築してレンダリングするライブラリの実行用
 */
object Main {

	def main(args: Array[String]) = {
		// クラスの拡張
		println("\n==== Class extended ====")
		val ae = new ArrayElement(Array("hello", "worlds"))
		println("ae.width = " + ae.width)
		println("ae.height = " + ae.height)

		// 多相性・動的束縛(ダイナミックバインディング)
		println("\n==== Polymorphism and Dynamic binding ====")
		val le = new LineElement("scala")
		val ue = new UniformElement('x', 2, 3)
		invokeDemo(ae)
		invokeDemo(le)
		invokeDemo(ue) // demo()をオーバーライドをしていないためスーパークラスのdemo()の実装を継承

		// above, beside, toStringの実装
		println("\n==== Implement above, beside, toString ====")
		val ae2 = new ArrayElement(Array(" scala", "!"))
		println("<above method result >")
		val aeAbove = ae.above(ae2)
		println(aeAbove)
		println("<beside method result >")
		val aeBeside = ae.beside(ae2)
		println(aeBeside)

		println("\n==== Hide implement class (define singleton object) ====")
		val ae3 = Element.elem(Array("ArrayElementSingleton", "TEST"))
		println(ae3)
		val le2 = Element.elem("LineElementSingleton")
		println(le2)
		val ue2 = Element.elem('x', 20, 10)
		println(ue2)
	}

	def invokeDemo(e: ElementOld) {
		e.demo()
	}
}