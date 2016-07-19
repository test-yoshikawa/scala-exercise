package nextstep

/**
 * Set と Map　サンプル
 */
object SetMap {
	def main(args: Array[String]) {
		// immutableな集合
		var jetSet = Set("Boeing", "Airbus")
		jetSet += "Lear"	// val変数の場合は実行エラー
		println(jetSet.contains("lear"))

		// mutable Set (import、もしくは初期化するときにパッケージまで指定する)
		import scala.collection.mutable.Set
		val movieSet = Set("Hitch", "Poltergeist")
		// val movieSet = scala.collection.mutable.Set("Hitch", "Poltergeist")
		movieSet += "Shrek"
		println(movieSet)

		// immutable Map
		val romanNumeral = Map(1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five")
		println(romanNumeral)

		// mutable Map(import、もしくは初期化するときにパッケージまで指定する)
		import scala.collection.mutable.Map
		val treasureMap = Map[Int, String]()
		// val treasureMap = scala.collection.mutable.Map[Int, String]()
		treasureMap += (1 -> "Go to island.")
		treasureMap += (2 -> "Find big X on ground.")
		treasureMap += (3 -> "Dig.")
		println(treasureMap(2))
	}
}