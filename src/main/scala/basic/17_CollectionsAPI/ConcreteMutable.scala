package basic.collectionsapi

object ConcreteMutable {
	def main(args: Array[String]) {
		println("==== ArrayBuffer ====")
		// 末尾にも効率的にアクセスでき、要素追加は一定の償却時間（平均では定数とみなせる時間）で実行できる
		val buf = scala.collection.mutable.ArrayBuffer.empty[Int]
		println("buf: " + buf)
		println("buf += 1: " + (buf += 1))
		println("buf += 10: " + (buf += 10))
		println("buf.toArray: " + (buf.toArray))

		println("\n==== ListBuffer ====")
		// ArrayBufferと似ているが、連結リストを使っている
		val bufList = scala.collection.mutable.ListBuffer.empty[Int]
		println("bufList: " + bufList)
		println("bufList += 1: " + (bufList += 1))
		println("bufList += 10: " + (bufList += 10))
		println("bufList.toList: " + bufList.toList)

		println("\n==== StringBuilder ====")
		// 文字列の組み立てに役立つ。非常によく使われるためデフォルトでimportされている
		val bufStr = new StringBuilder
		println("bufStr: " + bufStr)
		println("bufStr += 'a': " + (bufStr += 'a'))	// +=: Char型で指定
		println("bufStr ++= \"bcdef\": " + (bufStr ++= "bcdef"))	// ++= String型で指定
		println("bufStr.toString: " + bufStr.toString)

		println("\n==== Queue ====")
		val queue = new scala.collection.mutable.Queue[String]
		println("queue: " + queue)
		println("queue += \"a\": " + (queue += "a"))
		println("queue ++= List(\"b\", \"c\"): " + (queue ++= List("b", "c")))
		println("queue: " + queue)
		println("queue.dequeue: " + queue.dequeue)
		println("queue: " + queue)

		println("\n==== Stack ====")
		val stack = new scala.collection.mutable.Stack[Int]
		println("stack: " + stack)
		println("stack.push(1): " + stack.push(1))
		println("stack: " + stack)
		println("stack.push(2): " + stack.push(2))
		println("stack: " + stack)
		println("stack.top: " + stack.top)
		println("stack: " + stack)
		println("stack.pop: " + stack.pop)
		println("stack: " + stack)

		println("\n==== Hashtable ====")
		val map = scala.collection.mutable.HashMap.empty[Int, String]
		println("map: " + map)
		println("map += (1 => \"make a web site\")" + (map += (1 -> "make a web site")))
		println("map += (3 => \"profit!\")" + (map += (3 -> "profit!")))
		println("map: " + map)
		println("map(1): " + map(1))
		println("map contains 2: " + (map contains 2))
	}
}