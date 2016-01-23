package codeIQ

import scala.io.StdIn.readLine

/**
 * 文章を複数の文に分割する
 * ・句点(.)、疑問符(?)、感嘆符(!)の直後にスペースが続く場合を、文の区切り対象とする
 * ・スペースが続かない場合は、区切り対象としない
 * ・以下の例外においては、スペースが続いても区切り対象としない
 * 　・直前に、Mr. Ms. Mrs. Mt. ４種の略称がある場合
 * 　・直前の文字列が、すべて数字で構成されている場合
 */
object separateEnglishSentence {

	def main(args: Array[String]) {
			var input = readLine()

			while(input.nonEmpty) {
				println("===== result =====")
				println(separate(input))
				println("==================")
				input = readLine()
			}
	}

	/**
	 * 文章を複数の文に分割する
	 */
	def separate(input: String) ={
		val separates = Seq("""[\w 0-9]+\. """.r, """\? """.r, """! """.r)
		val excludes = Seq("""Mr. """.r, """Ms. """.r, """Mrs. """.r, """Mt. """.r, """[0-9]. """.r)
		var result = input
		separates.foreach(
			separate => 
				result = separate.replaceAllIn(result, m => 
					if (excludes.exists(e => e.findFirstIn(m.toString).nonEmpty)) m.toString
					else m + "\n"
				)
		)
		result
	}
}