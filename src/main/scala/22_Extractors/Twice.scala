package basic.extractors

/**
 * Twice文字列抽出しオブジェクト
 */
object Twice {

	def apply(s: String): String = s + s

	def unapply(s: String): Option[String] = {
		val length = s.length / 2
		val half = s.substring(0, length)
		if (half == s.substring(length)) Some(half) else None
	}

	/**
	 * userが2つ連続のメールアドレスを抽出
	 */
	def userTwiceUpper(s: String) = s match {
		case Email(Twice(x @ UpperCase()), domain) =>	// [x @ UpperCase()]: UpperCaseがマッチしたパターンに変数xを束縛する
			"match: " + x + " in domain " + domain
		case _ =>
			"no match"
	}
}