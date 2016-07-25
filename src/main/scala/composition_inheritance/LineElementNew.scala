package composition_inheritance

/** ArrayElementを拡張 */
class LineElementNew(s: String) extends ElementNew {

	val contents = Array(s)

	override val width = s.length

	override val height = 1
}