package Extractors

/**
 * Email文字列抽出しオブジェクト
 */
object Email extends ((String, String) => String) {
	// 注入メソッド（オプション）
	def apply(user: String, domain: String) = user + "@" + domain

	// 抽出メソッド（必須）
	def unapply(str: String): Option[(String, String)] = {
		val parts = str split "@"
		if (parts.length == 2) Some(parts(0), parts(1)) else None
	}

	/**
	 * メールアドレスのuserとdomainを抽出
	 */
	def selectorString(s: String) = s match {
		case Email(user, domain) => 
			"user: " + user + ", domain: " + domain
		case _ => 
			"not an email address"
	}
}