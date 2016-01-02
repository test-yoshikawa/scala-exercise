package basic.CompositionAndInheritance

/**
 * ArrayElementを拡張
 */
class LineElement2(s: String) extends Element {

	val contents = Array(s)

	override val width = s.length

	override val height = 1
}