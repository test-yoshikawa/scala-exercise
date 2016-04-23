package basic.classandobject

/**
 * クラスオブジェクト実行用
 */
object Main{

	def main(args: Array[String]) {
		//=======================
		// シングルトン
		//=======================
		println("execute ChecksumAccumlator")
		println("Chapter4 => " + CheckSumAccumlator.calculate("Chapter4"))
		println()
		println("Chapter4.1 => " + CheckSumAccumlator.calculate("Chapter4.1"))
		println()
		println("Chapter4 => " + CheckSumAccumlator.calculate("Chapter4"))
	}
}