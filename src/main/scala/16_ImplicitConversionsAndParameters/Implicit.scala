package ImplicitConversionsAndParameters

object Implicit {
	implicit def stringToDouble(x: String): Int = x.length
}