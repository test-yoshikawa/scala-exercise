package scala.Collections

import scala.collection._

/**
 * @author Yuki Yoshikawa
 */
object mapSample {

	def main(args: Array[String]) {
		val map = mutable.Map.empty[String, Int]
		map("hello") = 1
		map("there") = 2
		println("map変数：" + map)
		println("map(\"hello\")：" + map("hello"))
		println("map(\"there\")：" + map("there"))
		// println("map(\"empty\")：" + map("empty"))	// 例外発生：NoSuchElementException

		// 文章から単語を取得する
		val text = "See Spot run. Run, Spot . Run!"
		print("Mapを使用して単語を取得：")
		println(countWords(text))
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
}