package scalableProgramming.chapter29

/**
 * 処理実行用オブジェクト
 */
object main {
	
	def main(args: Array[String]): Unit = {
		val apple = SimpleDatabase.foodNamed("Apple").get
		println(apple)

		val recipes = SimpleBrowser.recipesUsing(apple)
		println(recipes)
	}
	
}