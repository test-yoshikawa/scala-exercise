package abstract_members.initialize

/** 遅延評価val デモ */
object LazyDemo {
	lazy val x = { println("initializing x"); "done" }
}