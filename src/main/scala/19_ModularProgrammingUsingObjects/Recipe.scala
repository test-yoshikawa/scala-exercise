package ModularProgrammingUsingObjects

/**
 * Recipeエンティティクラス
 */
abstract class Recipe(
	val name: String,	// 
	val ingredients: List[Food],	// 材料リスト
	val instructions: String	// 作り方
) {
	override def toString = name
}