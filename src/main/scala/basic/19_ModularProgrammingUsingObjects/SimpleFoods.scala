package basic.ModularProgrammingUsingObjects

/**
 * Foods　トレイト
 */
trait SimpleFoods {
	object Pear extends Food("Pear")
	def allFoods = List(Apple, Pear)
	def allCategories = Nil
}