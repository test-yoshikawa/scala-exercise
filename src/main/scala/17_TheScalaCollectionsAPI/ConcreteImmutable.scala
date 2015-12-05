package TheScalaCollectionsAPI

object ConcreteImmutable {

	def main(args: Array[String]) {
		println("==== Stream ====")
		// Listと似ているが、要素が遅延評価される。無限に長くすることができる
		val strm = 1 #:: 2#:: 3#:: Stream.empty
		println("strm: " + strm)
		val fibs = fibForm(1, 1).take(7)	// take: n個の要素から成るStreamを返す
		println("fibForm(1, 1).take(7): " + fibs.toList)

		println("==== Vector ====")
		// Listは先頭要素以外の要素のアクセスや変更には、Listの深さに比例した時間がかかるが、
		// Vectorは先頭要素以外にも効率的にアクセスできる。（実質的に一定時間）
		val vec = scala.collection.immutable.Vector.empty
		val vec2 = vec :+ 1 :+ 2
		val vec3 = 100 +: vec2
		println("vec: " + vec)
		println("vec :+ 1 :+ 2 => vec2: " + vec2)
		println("100 +: vec2 => vec3: " + vec3)
		println("vec3(0): " + vec3(0))
		val vec4 = Vector(1, 2, 3)
		println("vec4: " + vec4)
		println("vec4 updated (2, 4): " + (vec4 updated (2, 4)))

		println("\n==== immutable Stack ====")	// LIFO: 後入れ後出し
		val stack = scala.collection.immutable.Stack.empty
		val hasOne = stack.push(1)
		println("stack: " + stack)
		println("stack.push(1) => hasOne: " + hasOne)
		println("hasOne.top: " + hasOne.top)
		println("hasOne.pop: " + hasOne.pop)
		println("hasOne: " + hasOne)

		println("\n==== immutable Queue ====")	// LIFO: 先入れ先出し
		val queue = scala.collection.immutable.Queue[Int]()
		val has1 = queue.enqueue(1)
		val has123 = has1.enqueue(List(2, 3))
		val (element, has23) = has123.dequeue
		println("queue: " + queue)
		println("queue.enqueue(1) => has1: " + has1)
		println("has1.enqueue(List(2, 3)) => has123: " + has123)
		println("has123.dequeue => element: " + element + ", has23: " + has23)

		println("\n==== Range ====")
		println("1 to 3: " + (1 to 3))
		println("5 to 13 by 3: " + (5 to 13 by 3))
		println("1 until 3: " + (1 until 3))

		println("\n==== ListMap ====")
		val map = collection.immutable.ListMap(1 -> "one", 2 -> "two")
		println("map: " + map)
		println("map(2): " + map(2))
	}

	def fibForm(a: Int, b: Int): Stream[Int] = a #:: fibForm(b, a + b)	// 「#::」の右辺は要求されるまで評価されない
}