package scalableProgramming.chapter10

import Element.elem
/**
 * @author Yuki Yoshikawa
 */
object Element {
	// 非公開クラスの実装の隠ぺい
	private class ArrayElementHidden(val contents: Array[String]) extends Element

	private class LineElementHidden(s: String) extends Element {
		def contents = Array(s)
		override val width = s.length
		override val height = 1
	}

	private class UniformElementHidden(ch: Char, override val width: Int, override val height: Int) extends Element {
		def contents = Array.fill(height)(ch.toString * width)
	}

	// ファクトリーメソッドの実装
	def elem(contents: Array[String]): Element = new ArrayElementHidden(contents)
	def elem(line: String): Element = new LineElementHidden(line)
	def elem(ch: Char, width: Int, height: Int): Element = new UniformElementHidden(ch, width, height)
}

abstract class Element {
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
	def above(that: Element): Element = {
		val this1 = this widen that.width
		val that1 = that widen this.width
		elem(this1.contents ++ that1.contents)
	}

	/**
	 * 2つの要素を並べる
	 */
	def beside(that: Element): Element = {
		val this1 = this heighten that.height
		val that1 = that heighten this.height
		// 命令型スタイル
		//		for (i <- 0 until this.contents.length) {
		//			contents(i) = this.contents(i) + that.contents(i)
		//		}
		elem(for ((line1, line2) <- this1.contents zip that1.contents) yield line1 + line2)
	}

	/**
	 * 同じ幅になるように調整する
	 */
	def widen(w:Int): Element = {
		if (w <= height) this
		else {
			val left = elem(' ', (w - width) / 2, height)
			val right = elem(' ', w - width - left.width, height)
			left beside this beside right
		}
	}

	/**
	 * 同じ高さになるように調整する
	 */
	def heighten(h: Int): Element = {
		if (h <= height) this
		else {
			val top = elem(' ', width, (h - height) / 2)
			val bot = elem(' ', width, h - height - top.height)
			top above this above bot
		}
	}

	override def toString = contents mkString "\n"
}