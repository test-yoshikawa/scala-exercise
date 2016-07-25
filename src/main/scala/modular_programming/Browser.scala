package modular_programming

/** ブラウザークラス */
abstract class Browser {
  val database: Database

  /** 対象の材料を使用するレシピ一覧を取得する
    *
    * @param food 材料
    * @return レシピ一覧
    */
  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe => recipe.ingredients.contains(food))

  /** カテゴリを出力する
    *
    * @param category 登録されているカテゴリ
    */
  def displayCategory(category: database.FoodCategory) {
    println(category)
  }
}