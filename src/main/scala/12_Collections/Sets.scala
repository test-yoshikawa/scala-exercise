package basic.collections

/**
 * Set サンプル
 * ・==で比較して同じとされる要素が1つしかない（重複する要素がない）
 */
object Sets {

	def main(args: Array[String]) {
		// 単語を取得する（大文字小文字は別）
		val text = "See Spot run. Run, Spot . Run!"
		val wordsArray = text.split("[ !,.]+")
		println("Sentence: " + text)
		print("Get word: ")
		println(wordsArray.mkString(" "))

		// 単語の種類を取得する
		val wordsSet = scala.collection.mutable.Set.empty[String]
		for (word <- wordsArray) wordsSet += word.toLowerCase
		print("get kinds of word: ")
		println(wordsSet)

		println("\n==== Set methods ====")
		showSetMethods()
	}

	/**
	 * Setの一般的な操作を出力する
	 */
	def showSetMethods() {
		val nums = Set(1, 2, 3) // immutableな集合を作成
		println("nums: " + nums)
		println("nums + 5: " + (nums + 5))	// 要素が追加された集合を返す
		println("nums - 3: " + (nums - 3))	// 指定した要素が削除された集合を返す
		println("nums ++ List(5, 6): " + (nums ++ List(5, 6)))	// 複数の要素を追加する(順序は保証されない？)
		println("nums -- List(1, 2, 5): " + (nums -- List(1, 2, 5)))	// 複数の要素を取り除く
		println("nums & Set(1, 3, 5, 7): " + (nums & Set(1, 3, 5, 7)))	// 2つの集合の積集合を返す
		println("nums.size: " + nums.size)	// 集合のサイズを返す
		println("nums.contains(3): " + nums.contains(3))	// 要素が含まれているか判定する
		val words = scala.collection.mutable.Set.empty[String]	// 空のmutable集合を返す
		println("mutable.words: " + words)
		words += "the"	// 要素を追加する
		println("words add \"the\": " + words)
		words -= "the"	// 要素を削除する
		println("words delete \"the\": " + words)
		words ++= List("do", "re", "mi")	// 複数の要素を追加する
		println("words add multiple elements: " + words)
		words --= List("do", "re")	// 複数の要素を削除する
		println("words delete multiple elements: " + words)
		words.clear // すべての要素を削除する
		println("words clear: " + words)
	}
}