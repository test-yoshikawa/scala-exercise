package pattern_match.expr

/** Option型 サンプル */
object MainForOption {

  /** メイン実行よう
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    // Option型
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")
    // getメソッドは引数のキーに対応する値があるときはSome(value)を返し、そうでない場合はNoneを返す
    val capital1 = capitals get "France"
    val capital2 = capitals get "America"
    println(capital1)
    println(capital2)
    println(show(capital1))
    println(show(capital2))
  }

  /** Optionの中身を取得する
    *
    * @param x Option[String]
    * @return x: String where:
    *         - x when x: Some(x)
    *         - "?" when other
    */
  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }
}