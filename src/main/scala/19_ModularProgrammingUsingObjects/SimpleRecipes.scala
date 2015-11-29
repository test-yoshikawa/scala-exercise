package ModularProgrammingUsingObjects

/**
 * Recipes　トレイト
 */
trait SimpleRecipes {
	// 自分型を指定する
	this: SimpleFoods =>
	object FruitSalad extends Recipe(
		"fruit salad",
		List(Apple, Pear),
		"Mix it all together"
		)
	def allRecipes  =List(FruitSalad)
}