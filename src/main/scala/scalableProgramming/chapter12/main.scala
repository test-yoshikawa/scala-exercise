package scalableProgramming.chapter12

/**
 * @author Yuki Yoshikawa
 */
object main {

	def main(args: Array[String]) {
		// トレイトサンプル①
		println("==== トレイトサンプル① ====")
		val frog = new Frog
		frog.philosophize()
		val phil: Philosophical = frog
		phil.philosophize()

		// トレイトサンプル②
		println("==== トレイトサンプル② ====")
		println("＜値を2倍にする＞")
		// トレイトをミックスインしたインスタンスを生成
		val queue1 = new MyQueue
		queue1.put(10)
		println(queue1.get())

		// インスタンス生成時にトレイトをミックスインする
		val queue2 = new BasicIntQueue with Doubling
		queue2.put(20)
		println(queue2.get())

		println("＜フィルターをかけてインクリメントをする＞")
		val queue3 = new BasicIntQueue with Incrementing with Filtering
		// putメソッドは最も右のトレイトのメソッドが適用される
		queue3.put(-1)
		queue3.put(0)
		queue3.put(1)
		print("new BasicIntQueue with Incrementing with Filtering : ")
		println(queue3.get() + ", " + queue3.get())

		val queue4 = new BasicIntQueue with Filtering with Incrementing
		queue4.put(-1)
		queue4.put(0)
		queue4.put(1)
		print("new BasicIntQueue with Filtering with Incrementing : ")
		println(queue4.get() + ", " + queue4.get() + ", " + queue4.get())


	}
}