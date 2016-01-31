package functionalProgramming

import functionalProgramming.List._

/**
 * リスト操作実行用オブジェクト
 */
object ListExecute {

	def main(args: Array[String]): Unit = {
		val data = List(1,2,3,4,5)
		val x = data match {
			case Cons(x, Cons(2, Cons(4, _))) => "head: " + x
			case Nil => "Nil" + 42
			case Cons(x, Cons(y, Cons(3, Cons(4, _)))) => "first, second summary: " + (x + y)
			case Cons(h, t) => "summary: " + (h + sum(t))
			case _  => "other" + 101
		}
		println("[ List(1,2,3,4,5) matching ] " + x)
		val listTail = tail(data)
		println("List(1,2,3,4,5).tail: " + mkString(listTail, ","))
		val listSetHead = setHead(data, 6)
		println("List(1,2,3,4,5).setHead(6): " + mkString(listSetHead, ","))
		val listDrop = drop(data, 3)
		println("List(1,2,3,4,5).drop(3): " + mkString(listDrop, ","))
		val listDropWhile = dropWhile(data, (x: Int) => x < 4)
		println("List(1,2,3,4,5).dropwhile(_ < 4): " + mkString(listDropWhile, ","))
		val listDropWhileImprove = dropWhileImprove(data)(x => x < 5) // 型指定する必要なくなる
		println("List(1,2,3,4,5).dropWhileImprove(_ < 5): " + mkString(listDropWhileImprove, ","))
		val listAppend = appendViaFoldRight(data, List(6,7))
		println("List(1,2,3,4,5).appendViaFoldRight: " + mkString(listAppend, ","))
	}
}