package scala.CompositionAndInheritance

/**
 * @author Yuki Yoshikawa
 */
class UniformElement(ch: Char, override val width: Int, override val height: Int) extends ElementOld {
	def contents = Array.fill(height)(ch.toString * width)
}