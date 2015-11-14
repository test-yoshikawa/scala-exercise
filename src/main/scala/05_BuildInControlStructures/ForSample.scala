package scala.BuildInControlStructures

/**
 * For文　サンプル
 */
object ForSample {

	def main(args: Array[String]): Unit = {

		println("==== for (i <- 1 to 4) ====")
		for (i <- 1 to 4) println("Iteration " + i)

		println()
		println("==== for (i <- 1 until 4) ====") // =>for (i <- 1 to 3)
		for (i <- 1 until 4) println("Iteration " + i)

		println()
		println("==== for filter ====")
		val filesHere = (new java.io.File(".\\src\\main\\scala\\scala\\05_BuildInControlStructures")).listFiles
		for(file <- filesHere if file.getName.endsWith(".scala"))
			println(file)

		println()
		println("==== for 入れ子 ====")
		grep(filesHere, ".*gcd.*")

		println()
		println("==== for yield ====")

		// コレクションの作成
		def scalaFiles = for { file <- filesHere if file.getName.endsWith(".scala")} yield file
		scalaFiles.foreach(println)
	}

	/**
	 * ファイル内容を行単位に読み込む
	 */
	def fileLines(file: java.io.File) =
		scala.io.Source.fromFile(file).getLines().toList

	/**
	 * grepを行う
	 */
	def grep(filesHere: Array[java.io.File], pattern: String) = {
		for(file <- filesHere if file.getName.endsWith(".scala");
				line <- fileLines(file) if line.trim.matches(pattern)) println(file + ": " + line.trim)

		for{
			file <- filesHere
				if file.getName.endsWith(".scala");
			line <- fileLines(file)
				trimmmed = line.trim
				if trimmmed.matches(pattern)
			} println(file + ": " + trimmmed)
	}

}