package modular_programming

/** Recipes トレイト */
trait SimpleRecipes {
  // 自分型を指定する
  this: SimpleFoods => object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Pear),
    "Mix it all together"
  )

  /** すべてのレシピを取得する
    *
    * @return all Recipes
    */
  def allRecipes = List(FruitSalad)
}