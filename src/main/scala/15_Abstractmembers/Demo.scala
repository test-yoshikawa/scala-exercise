package scala.Abstractmembers

/**
 * 遅延評価val デモ
 *
 */
object Demo {
	val x = { println("initializing x"); "done" }
}