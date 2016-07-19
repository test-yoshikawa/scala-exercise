package classandobject

/**
 * Applicationトレイトを利用したアプリケーション
 */
object MainExtendsApp extends App {
		println("execute ChecksumAccumlator")
		println("Chapter4 => " + CheckSumAccumlator.calculate("Chapter4"))
		println()
		println("Chapter4.1 => " + CheckSumAccumlator.calculate("Chapter4.1"))
		println()
		println("Chapter4 => " + CheckSumAccumlator.calculate("Chapter4"))
}