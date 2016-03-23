package basic.abstractmembers

/**
 * 遅延評価val デモ
 *
 */
object LazyDemo {
	lazy val x = { println("initializing x"); "done" }
}