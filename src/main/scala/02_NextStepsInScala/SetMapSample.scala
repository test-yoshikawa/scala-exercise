package NextStepsInScala

/**
 * Set と Map　サンプル
 */
object SetMapSample {

	def main(args: Array[String]): Unit = {
		// ミュータブル(変更可能)な集合
		var jetSet = Set("Boeing", "Airbus")
		jetSet += "Lear"
		println(jetSet.contains("lear"))

		// イミュータブル(変更不可)な集合(importする必要あり)
		import scala.collection.mutable.Set
		// var movieSet = Set("Hitch", "Poltergeist") // コンパイルエラー
		val movieSet = Set("Hitch", "Poltergeist")
		movieSet += "Shrek"
		println(movieSet)

		// イミュータブルなマップ
		val romanNumeral = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five")
		println(romanNumeral)

		// ミュータブルなマップ(importする必要あり)
		import scala.collection.mutable.Map
		val treasureMap = Map[Int, String]()
		treasureMap += (1 -> "Go to island.")
		treasureMap += (2 -> "Find big X on ground.")
		treasureMap += (3 -> "Dig.")
		println(treasureMap(2))


	}
}