package scala.ClassesAndObjects

/**
 * @author Yuki Yoshikawa
 */
object main {

	def main(args: Array[String]): Unit = {

		//=======================
		// シングルトン
		//=======================
		println("execute ChecksumAccumlator")
		println(ChecksumAccumlator.calculate("Chapter4"))
		println(ChecksumAccumlator.calculate("Chapter4.1"))
		println(ChecksumAccumlator.calculate("Chapter4"))
	}
}