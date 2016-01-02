package basic.Traits

/**
 * トレイトサンプル　実行用
 */
object Main {

	def main(args: Array[String]) {
		println("\n==== Trait Sample 1 (Mixin) ====")
		val frog = new Frog
		frog.philosophize()
		val phil: Philosophical = frog
		phil.philosophize()

		println("\n==== Trait Sample 2 (Queue doubling element) ====")
		print("Instance Class mixed in Trait : ")
		// トレイトをミックスインしたインスタンスを生成
		val queue1 = new MyQueue
		queue1.put(10)
		println(queue1.get())

		// インスタンス生成時にトレイトをミックスインする
		print("Mix in Trait when Class instantinate : ")
		val queue2 = new BasicIntQueue with Doubling
		queue2.put(10)
		println(queue2.get())

		println("\n==== Filter And Increment ==== ")
		val queue3 = new BasicIntQueue with Incrementing with Filtering // 最も右側のTraitのメソッドが最初に呼び出される
		queue3.put(-1)
		queue3.put(0)
		queue3.put(1)
		print("new BasicIntQueue with Incrementing with Filtering : ")
		println(queue3.get() + ", " + queue3.get())

		val queue4 = new BasicIntQueue with Filtering with Incrementing
		queue4.put(-2)	// Incrementing : -1 => Filtering : putされない
		queue4.put(-1)
		queue4.put(0)
		queue4.put(1)
		print("new BasicIntQueue with Filtering with Incrementing : ")
		println(queue4.get() + ", " + queue4.get() + ", " + queue4.get())
	}
}