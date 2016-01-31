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

		println("sample data: List[ %s ]".format(mkString(data, ",")))
		println("=== method ===")
		println("pattern match: " + x)
		val listTail = tail(data)
		println("tail: " + mkString(listTail, ","))
		val listSetHead = setHead(data, 6)
		println("setHead(6): " + mkString(listSetHead, ","))
		val listDrop = drop(data, 3)
		println("drop(3): " + mkString(listDrop, ","))
		val listDropWhile = dropWhile(data, (x: Int) => x < 4)
		println("dropwhile(_ < 4): " + mkString(listDropWhile, ","))
		val listDropWhileImprove = dropWhileImprove(data)(x => x < 5) // 型指定する必要なくなる
		println("dropWhileImprove(_ < 5): " + mkString(listDropWhileImprove, ","))
		val listAppend = appendViaFoldRight(data, List(6,7))
		println("appendViaFoldRight: " + mkString(listAppend, ","))
	}
}