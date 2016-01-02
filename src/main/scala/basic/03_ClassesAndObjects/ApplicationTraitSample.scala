package basic.ClassesAndObjects

/**
 * Applicationトレイト
 */
object ApplicationTraitSample extends App {
		println("execute ChecksumAccumlator")
		println("Chapter4 => " + ChecksumAccumlator.calculate("Chapter4"))
		println()
		println("Chapter4.1 => " + ChecksumAccumlator.calculate("Chapter4.1"))
		println()
		println("Chapter4 => " + ChecksumAccumlator.calculate("Chapter4"))
}