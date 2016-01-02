package basic.CompositionAndInheritance

/**
 * 指定された文字をかけるだけ新しい書式のElement
 */
class UniformElement(ch: Char, override val width: Int, override val height: Int) extends ElementOld {
	def contents = Array.fill(height)(ch.toString * width)
}