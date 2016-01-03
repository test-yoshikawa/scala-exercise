package basic.WorkingWithLists

object HeigherOrderMethod {

	def main(args: Array[String]) {
		// Listのマッピング
		println("==== List mapping : map, flatMap, foreach ====")
		val nums = List(1, 2, 3)
		val words = List("the", "quick", "brown", "fox")
		val mappedNums = nums map (_ + 1)
		val lengthWords = words map (_.length)
		val reverseWords = words map (_.toList.reverse.mkString)
		println(lengthWords)
		println(reverseWords)

		val mappedWords = words map (_.toList)
		val flatMappedWords = words flatMap (_.toList)
		println(mappedWords)
		println(flatMappedWords)

		// 1<=j<i<5になるすべての(i, j)の対のリストを作る
		val rangeResult = List.range(1, 5) flatMap (i => List.range(1, i) map (j => (i, j)))
		println("List.range(1, 5) meets (1<=i<j<5) => " + rangeResult)

		var sum = 0
		List(1, 2, 3, 4, 5) foreach (sum += _)
		println("List(1, 2, 3, 4, 5) summary => " + sum)

		// Listのフィルタリング
		println("\n==== List filtering : filter, partition, find, takeWhile, dropWhile, span ====")
		val filterList = List(1, 2, 3, 4, 5) filter ( _ % 2 == 0)				// 引数の条件を満たす要素のListを返す
		val partitionList = List(1, 2, 3, 4, 5) partition ( _ % 2 == 0)	// 引数の条件を満たすListと満たさないListからなるTupleを返す
		val findList = List(1, 2, 3, 4, 5) find ( _ % 2 == 0)						// 引数の条件を満たす最初の要素のオプション値を返す
		val findNoneList = List(1, 2, 3, 4, 5) find (_ < 0)							// 引数の条件を満たさないのでNoneを返す
		val takeWhileList = List(1, 2, 3, -4, 5) takeWhile ( _ > 0)			// 先頭から条件を満たす要素の連続からなるListを返す
		val dropWhileList = List(1, 2, 3, -4, 5) dropWhile (_ > 0)			// 先頭から条件を満たす要素の連続を削除して残りをListで返す
		val spanList = List(1, 2, 3, -4, 5) span (_ > 0)								// takeWhileとdropWhileを1つにまとめたTupleを返す
		println("filterList : " + filterList )
		println("partitionList : " + partitionList)
		println("findList : " + findList)
		println("findNoneList : " + findNoneList)
		println("takeWhileList : " + takeWhileList)
		println("dropWhileList : " + dropWhileList)
		println("spanList : " + spanList)

		// Listを対象とする述語関数
		println("\n==== Predicate function to target List: forall, exists")
		val existsOne = List(0, 0, 1, 0) exists (_ == 1)
		val forallZeroFalse = List(0, 0, 1, 0) forall (_ == 0)
		val forallZero = List(0, 0, 0, 0) forall (_ == 0)
		println("List(0, 0, 1, 0) exists 1 => " + existsOne)
		println("List(0, 0, 1, 0) forall 0 => " + forallZeroFalse)
		println("List(0, 0, 0, 0) forall 0 => " + forallZero)

		// Listの畳み込み
		println("\n==== List Convolusion: /:, :\\ ====")
		val flattenLeft = (" <conbine elements> " /: words) ( _ + " " + _)		// 左畳み込み
		val flattenRight = (words :\ " <conbine elements> ") ( _ + " " + _)		// 右畳み込み
		println("flattenLeft: " + flattenLeft)
		println("flattenRight: " + flattenRight)

		// Listのソート
		println("\n==== Sort List ====")
		val sortedNums = List(1, 2, -3, -4, 4, 5) sortWith (_ < _)
		val sortedWords = words sortWith ( _.length > _.length)
		println("sort nums (_ < _) : " + sortedNums)
		println("sort words (_.length > _.length)" + sortedWords)
	}
}