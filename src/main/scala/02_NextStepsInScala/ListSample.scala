package NextStepsInScala

/**
 * Listの操作サンプル
 */
object ListSample {

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
		println("Initialize thill List : " + thrill)
		println("Remove the first of thrill : " + thrill.drop(1))
		println("Remove the last of thrill : " + thrill.dropRight(2))
		println("Judge thrill satisfying the condition : " + thrill.exists(s => s == "until"))
		println("Return List satisfying the condition : " + thrill.filter(s => s.length == 4))
		println("Judge whether all elements of thrill satisfy : " + thrill.forall(s => s.endsWith("l")))
		print("foreach : ")
		thrill.foreach(s => print(s + ", "))					// 繰り返し処理
		println()
		print("foreach（easy version）")
		thrill.foreach(print)									// 繰り返し処理（簡潔版）
		println()
		println("Return the first element : " + thrill.head)
		println("Return List removed the last of element : " + thrill.init)
		println("List isEmpty : " + thrill.isEmpty)
		println("Return the last of element : " + thrill.last)
		println("Return the number of elements in the List : " + thrill.length)
		println("Return the List which the processing to each element of the List : " + thrill.map(s => s + "y"))
		println("Return a string that lined element of List : " + thrill.mkString(", "))
		println("Line up reverse order : " + thrill.reverse)
	}
}