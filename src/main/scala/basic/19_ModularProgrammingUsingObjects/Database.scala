package basic.ModularProgrammingUsingObjects

/**
 * データベースクラス
 */
abstract class Database extends FoodCategories {
	def allFoods: List[Food]
	def allRecipes: List[Recipe]
	def foodNamed(name: String) = allFoods.find(f => f.name == name)
}