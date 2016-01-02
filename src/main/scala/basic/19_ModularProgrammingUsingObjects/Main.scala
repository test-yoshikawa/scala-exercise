package basic.ModularProgrammingUsingObjects

/**
 * 処理実行用オブジェクト
 */
object Main {
	
	def main(args: Array[String]): Unit = {
		val apple = SimpleDatabase.foodNamed("Apple").get
		println(apple)

		val recipes = SimpleBrowser.recipesUsing(apple)
		println(recipes)

		val frozenFood = StudentDatabase.foodNamed("FrozenFood").get
		println(frozenFood)

		val studentRecipes = StudentBrowser.recipesUsing(frozenFood)
		println(studentRecipes)
	}
	
}