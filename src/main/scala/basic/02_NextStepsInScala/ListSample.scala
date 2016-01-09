package basic.NextStepsInScala

/**
 * Listの操作サンプル
 */
object ListSample {

	def main(args: Array[String]) {
		// Listの初期化
		val oneTwo = List(1, 2)
		val threeFour = List(3, 4)
		val oneTwoThreeFour = oneTwo ::: threeFour // Listの連結
		val twoThree = List(2, 3)
		val oneTwoThree = 1 :: twoThree // 新要素の追加

		println()
		// Listの結合
		println(oneTwo + " and " + threeFour + " were not mutated")
		println("Thus, " + oneTwoThreeFour + " were not mutated")
		println("list add result : " + oneTwoThree)

		// 初期化
		val thrill = "Will" :: "fill" :: "until" :: Nil	// Nil : 空のList
		println("Initialize thill List : " + thrill)

		// 先頭のN要素を取り除いたListを返す
		println("Remove the first of thrill : " + thrill.drop(1))
		
		// 末尾のN要素を取り除いたListを返す
		println("Remove the last of thrill : " + thrill.dropRight(2))

		// 引数の条件を満たしている要素があるかどうか判定する（return Boolean）
		println("Judge thrill satisfying the condition : " + thrill.exists(s => s == "until"))
		
		// 引数の条件を満たしている要素のListを返す
		println("Return List satisfying the condition : " + thrill.filter(s => s.length == 4))
		
		// すべての要素について、引数の条件を満たしているかどうか判定する（return Boolean）
		println("Judge whether all elements of thrill satisfy : " + thrill.forall(s => s.endsWith("l")))

		// 繰り返し処理
		print("foreach : ")
		thrill.foreach(s => print(s + ", "))					// 繰り返し処理
		println()
		
		// 繰り返し処理(簡易版)
		print("foreach (easy version) : ")
		thrill.foreach(print)									// 繰り返し処理（簡潔版）
		println()
		
		// 先頭要素を返す
		println("Return the first element : " + thrill.head)
		
		// 末尾の要素を取り除いた残りのListを返す
		println("Return List removed the last of element : " + thrill.init)
		
		// 空かどうか判定する（return Boolean）
		println("List isEmpty : " + thrill.isEmpty)
		
		// 末尾の要素を返す
		println("Return the last of element : " + thrill.last)
		
		// 要素数を返す
		println("Return the number of elements in the List : " + thrill.length)
		
		// リストの各要素に引数（関数）を適用したListを返す
		println("Return the List which the processing to each element of the List : " + thrill.map(s => s + "y"))

		// リストの要素を並べた文字列を返す
		println("Return a string that lined element of List : " + thrill.mkString(", "))
		
		// リストを逆順にしたListを返す
		println("Line up reverse order : " + thrill.reverse)

		// 先頭要素を取り除いた残りのListを返す
		println("Return List removed the first of element : " + thrill.tail)
		println()
	}
}