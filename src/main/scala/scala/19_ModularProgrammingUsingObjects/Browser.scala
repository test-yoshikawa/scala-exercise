package scala.ModularProgrammingUsingObjects

/**
 *ブラウザークラス
 */
abstract class Browser {
	val database: Database
	// 対象の材料を使用するレシピ一覧を取得する
	def recipesUsing(food: Food) =
		database.allRecipes.filter(recipe => recipe.ingredients.contains(food))

	def displayCategory(category: database.FoodCategory) {
		println(category)
	}
}