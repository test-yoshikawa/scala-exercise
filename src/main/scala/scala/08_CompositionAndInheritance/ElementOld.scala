package scala.CompositionAndInheritance

import ElementOld.elem
/**
 * @author Yuki Yoshikawa
 */
object ElementOld {
	// ファクトリーメソッドの実装
	def elem(contents: Array[String]): ElementOld = new ArrayElement(contents)
	def elem(line: String): ElementOld = new LineElement(line)
	def elem(ch: Char, width: Int, height: Int): ElementOld = new UniformElement(ch, width, height)
}


abstract class ElementOld {
	def contents: Array[String]

	// height、widthはdefで定義手もよいはvalのほうがわずかだが速い
	// クラスが初期化されるときに先に計算されているため
	val height = contents.length
	val width = if (height == 0) 0 else contents(0).length

	def demo() {
		println("Elements's implementation invoked")
	}

	/**
	 * 2つのcontentsを連結する
	 */
	def above(that: ElementOld): ElementOld = {
		elem(this.contents ++ that.contents)
	}

	/**
	 * 2つの要素を並べる
	 */
	def beside(that: ElementOld): ElementOld = {
		val contents = new Array[String](this.contents.length)
		// 命令型スタイル
		//		for (i <- 0 until this.contents.length) {
		//			contents(i) = this.contents(i) + that.contents(i)
		//		}
		elem(for ((line1, line2) <- this.contents zip that.contents) yield line1 + line2)
	}

	override def toString = contents mkString "\n"
}