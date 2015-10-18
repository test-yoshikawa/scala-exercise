package scalableProgramming.chapter20

/**
 * 遅延評価val デモ
 *
 * @author Yuki Yoshikawa
 */
object Demo {
	val x = { println("initializing x"); "done" }
}