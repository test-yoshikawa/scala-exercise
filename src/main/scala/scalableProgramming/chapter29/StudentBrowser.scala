package scalableProgramming.chapter29

/**
 * モック実装のブラウザーモジュール
 */
object StudentBrowser extends Browser {
	val database = StudentDatabase
}