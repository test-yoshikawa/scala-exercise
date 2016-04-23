package basic.controlabstraction

/**
 * 制御の抽象化
 *   ファイル操作系のAPI
 *
 */
object FileMatcher {

	private def filesHere = (new java.io.File("./src/main/scala/basic/07_controlabstraction")).listFiles

	/**
	 * ファイル名の後方一致検索
	 */
	def filesEnding(query: String) = {
		for (file <- filesHere; if file.getName.endsWith(query)) yield file
	}
	// ヘルパーメソッドを利用した重複コードの削除
	def filesEndingHelper(query: String) = filesMatching(query, _.endsWith(_))
	// クロージャーを利用した重複コードの削除
	def filesEndingClosure(query: String) = filesMatchingClosure(_.endsWith(query))

	/**
	 * ファイル名の部分一致検索
	 */
	def filesContaining(query: String) = {
		for (file <- filesHere; if file.getName.contains(query)) yield file
	}
	// ヘルパーメソッドを利用した重複コードの削除
	def filesContainingHelper(query: String) = filesMatching(query, _.contains(_))
	// クロージャーを利用した重複コードの削除
	def filesContainingClosure(query: String) = filesMatchingClosure(_.contains(query))

	/**
	 * ファイル名の正規表現検索
	 */
	def filesRegex(query: String) = {
		for (file <- filesHere; if file.getName.matches(query)) yield file
	}
	// ヘルパーメソッドを利用した重複コードの削除
	def filesRegexHelper(query: String) = filesMatching(query, _.matches(_))
	// クロージャーを利用した重複コードの削除
	def filesRegexClosure(query: String) = filesMatchingClosure(_.matches(query))

	/**
	 * ファイル検索 ヘルパーメソッド
	 */
	def filesMatching(query: String, matcher: (String, String) => Boolean) = {
		for (file <- filesHere; if matcher(file.getName, query)) yield file
	}

	/**
	 * ファイル検索 クロージャー
	 */
	def filesMatchingClosure(matcher: String => Boolean) = {
		for (file <- filesHere; if matcher(file.getName)) yield file
	}

	/**
	 * ファイル書き込み（カリー化を利用）
	 */
	def withPrintWriter(file: java.io.File)(op: java.io.PrintWriter => Unit) {
		val writer = new java.io.PrintWriter(file)
		try {
			op(writer)
			println("created file : " + file)
		} finally {
			writer.close();
		}
	}
}