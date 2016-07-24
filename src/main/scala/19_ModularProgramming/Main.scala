package modularprogramming

/** 処理実行用オブジェクト */
object Main {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
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