package basic.Collections

import scala.collection._

/**
 * Map　サンプル
 */
object MapSample {

	def main(args: Array[String]) {
		val map = mutable.Map.empty[String, Int]
		map("hello") = 1
		map("there") = 2
		println("map variable: " + map)
		println("map(\"hello\") value: " + map("hello"))
		println("map(\"there\") value: " + map("there"))
		try {
			println("map(\"empty\")：" + map("empty"))	// 例外発生：NoSuchElementException
		} catch {
			case e: NoSuchElementException => println("NoSuchElementException")
		}

		// 文章から単語を取得する
		val text = "See Spot run. Run, Spot . Run!"
		print("get words by Map : ")
		println(countWords(text))

		println("\n==== Map methods ====")
		showMapMethods()
	}

	/**
	 * 文章から単語を取得する
	 */
	def countWords(text: String) = {
		val counts = mutable.Map.empty[String, Int]

		for (ranWord <- text.split("[ !,.]+")) {
			val word = ranWord.toLowerCase
			val oldCount =
				if (counts.contains(word)) counts(word)
				else 0
			counts += (word -> (oldCount + 1))
		}
		counts
	}

	/**
	 * Map の一般的な操作を出力する
	 */
	def showMapMethods() {
		val nums = Map("i" -> 1, "li" -> 2)	// immutable な Map を作成
		println("immutable.nums: " + nums)
		println("nums + (\"vi\" -> 6): " + (nums + ("vi" -> 6)))	// エントリーを追加する
		println("nums - \"li\": " + (nums - "li")) // エントリーを削除する
		println("nums ++ List(\"iii\" -> 3, \"v\" -> 5): " + (nums ++ List("iii" -> 3, "v" -> 5)))	// 複数のエントリーを追加する
		println("nums -- List(\"i\", \"li\", \"iii\"): " + (nums -- List("i", "li", "iii")))	// 複数のエントリーを削除する
		println("nums.size: " + nums.size)	// Mapのサイズを返す
		println("nums.contains(\"li\"): " + nums.contains("li"))	// キーが含まれているか確認する(return type: Boolean)
		println("nums(\"li\"): " + nums("li"))	// 指定したキーに対応する値を返す
		println("nums.keys: " + nums.keys)	// キー(Iterable)を返す
		println("nums.keySet: " + nums.keySet)	// キーの集合を返す
		println("nums.values: " + nums.values)	// 値(Itterable)を返す
		println("nums.isEmpty: " + nums.isEmpty)	// 空かどうか確認する

		val words = scala.collection.mutable.Map.empty[String, Int]
		println("mutable.words: " + words)
		words += ("one" -> 1)
		println("add entry: " + words)
		words -= "one"
		println("delete entry: " + words)
		words ++= List("one" -> 1, "two" -> 2, "three" -> 3)
		println("add entrys: " + words)
		words --= List("one", "two")
		println("delete entrys: " + words)
	}
}