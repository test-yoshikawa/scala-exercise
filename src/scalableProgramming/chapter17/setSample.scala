package scalableProgramming.chapter17

/**
 * @author Yuki Yoshikawa
 */
object setSample {

	def main(args: Array[String]) {
		// 単語を取得する（大文字小文字は別）
		val text = "See Spot run. Run, Spot . Run!"
		val wordsArray = text.split("[ !,.]+")
		println("文章\t\t\t：" + text)
		print("単語を取得\t\t：")
		println(wordsArray.mkString(" "))

		// 単語の種類を取得する
		import scala.collection.mutable.Set
		val wordsSet = Set.empty[String]
		for (word <- wordsArray)
			wordsSet += word.toLowerCase
		print("単語の種類を取得：")
		println(wordsSet)
	}
}