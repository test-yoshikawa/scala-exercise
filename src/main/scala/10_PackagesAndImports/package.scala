package object PackagesAndImports {
	def showFruit(fruit: Fruit) {
		import fruit._
		println(name + "'s are" + color)
	}
}