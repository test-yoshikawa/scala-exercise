package controlabstraction

/** 制御の抽象化（ファイル操作系のAPI）*/
object FileMatcher {

  /** 対象パッケージ配下のファイルをリストで取得する
    *
    * @return ファイルリスト
    */
  private def filesHere = (new java.io.File("./src/main/scala/pattern_match")).listFiles

  /** ファイル名の後方一致検索
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesEnding(query: String) = {
    for (file <- filesHere; if file.getName.endsWith(query)) yield file
  }

  /** ファイル名の後方一致検索（ヘルパーメソッドを利用した重複コードの削除）
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesEndingHelper(query: String) = filesMatching(query, _.endsWith(_))

  /** ファイル名の後方一致検索（クロージャーを利用した重複コードの削除）
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesEndingClosure(query: String) = filesMatchingClosure(_.endsWith(query))

  /** ファイル名の部分一致検索
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesContaining(query: String) = {
    for (file <- filesHere; if file.getName.contains(query)) yield file
  }

  /** ファイル名の部分一致検索（ヘルパーメソッドを利用した重複コードの削除）
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesContainingHelper(query: String) = filesMatching(query, _.contains(_))

  /** ファイル名の部分一致検索（クロージャーを利用した重複コードの削除）
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesContainingClosure(query: String) = filesMatchingClosure(_.contains(query))

  /** ファイル名の正規表現検索
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesRegex(query: String) = {
    for (file <- filesHere; if file.getName.matches(query)) yield file
  }

  /** ファイル名の正規表現検索（ヘルパーメソッドを利用した重複コードの削除）
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesRegexHelper(query: String) = filesMatching(query, _.matches(_))

  /** ファイル名の正規表現検索（クロージャーを利用した重複コードの削除）
    *
    * @param query クエリ
    * @return 検索結果
    */
  def filesRegexClosure(query: String) = filesMatchingClosure(_.matches(query))

  /** ファイル検索（ヘルパーメソッド）
    *
    * @param query クエリ
    * @param matcher マッチ条件
    * @return 検索結果
    */
  def filesMatching(query: String, matcher: (String, String) => Boolean) = {
    for (file <- filesHere; if matcher(file.getName, query)) yield file
  }

  /** ファイル検索（クロージャー）
    *
    * @param matcher マッチ条件
    * @return 検索結果
    */
  def filesMatchingClosure(matcher: String => Boolean) = {
    for (file <- filesHere; if matcher(file.getName)) yield file
  }

  /** ファイル書き込み（カリー化）
    *
    * @param file ファイル
    * @param op 書き込み関数
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