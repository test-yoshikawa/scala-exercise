package basic.ModularProgrammingUsingObjects

/**
 * モック実装のデータベースモジュール
 */
object StudentDatabase extends Database {
	object FrozenFood extends Food("FrozenFood")
	object HeatItUp extends Recipe("heat it up", List(FrozenFood), "Microwave the 'food' for 10 minutes")
	def allFoods = List(FrozenFood)
	def allRecipes = List(HeatItUp)
	def allCategories = List(FoodCategory("edible", List(FrozenFood)))
}