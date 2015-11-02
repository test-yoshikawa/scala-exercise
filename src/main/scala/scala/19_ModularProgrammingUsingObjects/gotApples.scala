package scalableProgramming.chapter29

/**
 * リンゴのレシピを出力するオブジェクト
 */
object gotApple {
	
	def main(args: Array[String]): Unit = {
		val db: Database =
			if (args.nonEmpty && args(0) == "student") StudentDatabase
			else SimpleDatabase

		object browser extends Browser {
			val database: db.type = db 	// .typeをつけることで同じ型とコンパイラーに知らせる
		}
		val apple = SimpleDatabase.foodNamed("Apple").get
		for (recipes <- browser.recipesUsing(apple))
			println(recipes)
		for (category <- db.allCategories)
			browser.displayCategory(category)
	}
	
}