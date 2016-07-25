package extractors

/** メールアドレスのDomain抽出子オブジェクト */
object Domain {
  // 注入メソッド（オプション）
  def apply(parts: String*): String = parts.reverse.mkString(".")

  // 抽出メソッド（必須） 可変個のマッチ専用
  def unapplySeq(whole: String): Option[Seq[String]] = Some(whole.split("\\.").reverse)

  /** "yoshi"のメールアドレスチェック
    *
    * @param s String
    * @return true: OK, false: NG
    */
  def isYoshiInDotCom(s: String): Boolean = s match {
    case Email("yoshi", Domain("com", _*)) => true
    case _ => false
  }
}