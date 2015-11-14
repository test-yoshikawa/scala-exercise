package scala.CompositionAndInheritance

/**
 * @author Yuki Yoshikawa
 */
class LineElement2(s: String) extends Element {

	val contents = Array(s)

	override val width = s.length

	override val height = 1
}