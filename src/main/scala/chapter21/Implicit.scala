package scalableProgramming.chapter21

object Implicit {
	implicit def stringToDouble(x: String): Int = x.length
}