package scala.NextStepsInScala

/**
 * @author Yuki Yoshikawa
 */
object listSample {
	def main(args: Array[String]): Unit = {
		// Listの初期化
		val oneTwo = List(1, 2)
		val threeFour = List(3, 4)
		val oneTwoThreeFour = oneTwo ::: threeFour // Listの連結
		val twoThree = List(2, 3)
		val oneTwoThree = 1 :: twoThree // 新要素の追加

		println(oneTwo + " and " + threeFour + " were not mutated")
		println("Thus, " + oneTwoThreeFour + " were not mutated")
		println("list add result : " + oneTwoThree)

		val thrill = "Will" :: "fill" :: "until" :: Nil	// Nil : からのリスト
		println("thrillリストを初期化 : " + thrill)
		println("thrillの先頭N要素を取り除く : " + thrill.drop(1))
		println("thrillの末尾N要素を取り除く : " + thrill.dropRight(2))
		println("thrillに条件を満たす値が含まれているか判定 : " + thrill.exists(s => s == "until"))
		println("条件を満たす値のListを返すl : " + thrill.filter(s => s.length == 4))
		println("thrillの要素すべてが条件を満たしているかどうか判定 : " + thrill.forall(s => s.endsWith("l")))
		print("繰り返し処理 : ")
		thrill.foreach(s => print(s + ", "))					// 繰り返し処理
		println()
		print("繰り返し処理（簡潔版）")
		thrill.foreach(print)									// 繰り返し処理（簡潔版）
		println()
		println("先頭要素を返す : " + thrill.head)
		println("末尾の要素を取り除いたListを返す : " + thrill.init)
		println("Listが空かどうか返す : " + thrill.isEmpty)
		println("最後の要素を返す : " + thrill.last)
		println("Listの要素数を返す : " + thrill.length)
		println("Listの各要素に処理をしたListを返す : " + thrill.map(s => s + "y"))
		println("Listの要素を並べた文字列を返す : " + thrill.mkString(", "))
		println("逆順に並べる : " + thrill.reverse)
	}
}