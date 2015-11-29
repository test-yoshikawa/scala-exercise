package AbstractMembers

/**
 * 列挙型サンプル
 */
 object enumerationDample {

	 def main(args: Array[String]): Unit = {
	 	println("==== Color.values ====")
	 	for (c <- Color.values) println(c)

		println()
	 	println("==== Direction.values ====")
		for (d <- Direction.values) println(d)
		println()
		println("Direction.East.id: " + Direction.East.id)
		println("Direction(1): " + Direction(1))
	 }
	 
 }