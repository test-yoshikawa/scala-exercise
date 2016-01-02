package basic.ForExpressionsRevisited

case class Book(title: String, authors: String*)

/**
 * for式によるクエリー　サンプル
 */
object Book {
	val books: List[Book] = List(
			Book(
					"Structure and Interpretation of Computer Programs",
					"Abelson, Harold", "Sussman, Gerald"
				),
			Book(
					"Principle of Computer Design",
					"Aho, Alfred", "Ullman, Jeffrey"
				),
			Book(
					"Programming in Modula-2",
					"Wirth, Niklaus"
				),
			Book(
					"Elements of ML Programming",
					"Ullman, Jeffrey"
				),
			Book(
					"the Java Language Specification",
					"Gosling, James", "Joy, Bill", "Steele, Guy", "Brancha, Gilad"
				)
		)

	def main(args: Array[String]) {
		println("==== query by for ====")
		println("Books: \n" + books.mkString("\n"))
		val gosling = for(b <- books; a <- b.authors if a startsWith "Gosling") yield b.title
		println("\n== book's titles that author's firstName is 'Cosling ==")
		println(gosling)
		val includingProgram = for(b <- books; if (b.title indexOf "Program") >= 0) yield b.title
		println("\n== book's titles including 'Program' ==")
		println(includingProgram)
		val booksAuthors = for (b1 <- books; b2 <- books if b1 != b2; a1 <- b1.authors; a2 <- b2.authors if a1 == a2) yield a1
		println("\n== book's author who has written at least two or more books ==")
		println(removeDuplicates(booksAuthors))
	}

	/**
	 * リスト要素の重複を削除する
	 */
	def removeDuplicates[A](xs: List[A]): List[A] = {
		if (xs.isEmpty) xs
		// else xs.head :: removeDuplicates(xs.tail filter (x => x != xs.head))
		else xs.head :: removeDuplicates(for (x <- xs.tail if x != xs.head) yield x)	// ↑のコメントと同じ表現
	}
}