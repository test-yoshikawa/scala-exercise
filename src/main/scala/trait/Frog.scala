package traits

/** カエル */
class Frog extends Animal with Philosophical with HasLegs {

  override def toString = "green"

  /** 出力 */
  override def philosophize() {
    println("It ain't easy being " + toString + "!")
  }
}