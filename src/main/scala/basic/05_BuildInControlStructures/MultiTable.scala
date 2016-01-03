package basic.BuildInControlStructures

/**
 * 掛け算テーブル表示
 */
object MultiTable {

	def main(args: Array[String]) = {
		val table = multiTable()
		table.foreach(print)
		println()
	}

	/**
	 * 1段分をシーケンスとして返す
	 */
	def makeRowSeq(row: Int) = {
		for (col <- 1 to 10) yield {
			val prod = (row * col).toString
			val padding = " " * (4 - prod.length)
			padding + prod
		}
	}

	/**
	 * 1段分を文字列として返す
	 */
	def makeRow(row: Int) = makeRowSeq(row).mkString

	/**
	 * 行に1段分の文字列を収めた表を返す
	 */
	def multiTable() = {
		val tableSeq =
			for (row <- 1 to 10) yield makeRow(row)
		tableSeq.mkString("\n")
	}
}