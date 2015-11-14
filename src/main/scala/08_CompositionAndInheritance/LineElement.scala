package scala.CompositionAndInheritance

/**
 * @author Yuki Yoshikawa
 */
class LineElement(s: String) extends ArrayElement(Array(s)) {
	override val width = s.length

	override val height = 1

	override def demo() {
		println("LineElement's implementation invoked")
	}

}