package scalableProgramming.chapter12

/**
 * @author Yuki Yoshikawa
 */
class Frog extends Animal with Philosophical with HasLegs {
	override def toString = "green"

	override def philosophize() {
		println("It ain't easy being " + toString + "!")
	}
}