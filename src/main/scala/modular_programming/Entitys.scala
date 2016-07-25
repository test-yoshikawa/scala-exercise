package modular_programming

// テスト用のFoodとRecipeのサンプル
/** Appleクラス */
object Apple extends Food("Apple")

/** Orangeクラス */
object Orange extends Food("Orange")

/** Creamクラス */
object Cream extends Food("Cream")

/** Sugarクラス */
object Sugar extends Food("Sugar")

/** FruitSalad */
object FruitSalad extends Recipe("fruit salad", List(Apple, Orange, Cream, Sugar), "Stir it all together")