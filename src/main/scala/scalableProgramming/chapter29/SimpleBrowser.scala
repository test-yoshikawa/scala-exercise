package scalableProgramming.chapter29

/**
 * モック実装のブラウザーモジュール
 */
object SimpleBrowser extends Browser {
	val database = SimpleDatabase
}