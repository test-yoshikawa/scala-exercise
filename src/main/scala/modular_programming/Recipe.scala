package modular_programming

/** Recipeエンティティクラス */
abstract class Recipe(
  val name: String, // 名前
  val ingredients: List[Food],  // 材料リスト
  val instructions: String  // 作り方
) {
  override def toString = name
}