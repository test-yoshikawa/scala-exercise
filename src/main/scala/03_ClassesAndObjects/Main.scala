package ClassesAndObjects

/**
 * クラスオブジェクト実行用
 */
object Main{

	def main(args: Array[String]) {
		//=======================
		// シングルトン
		//=======================
		println("execute ChecksumAccumlator")
		println("Chapter4 => " + ChecksumAccumlator.calculate("Chapter4"))
		println()
		println("Chapter4.1 => " + ChecksumAccumlator.calculate("Chapter4.1"))
		println()
		println("Chapter4 => " + ChecksumAccumlator.calculate("Chapter4"))
	}
}