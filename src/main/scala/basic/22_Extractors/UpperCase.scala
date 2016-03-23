package basic.extractors

/**
 * UpperCase文字列抽出しオブジェクト
 */
object UpperCase {
	def unapply(s: String): Boolean = s.toUpperCase == s
}