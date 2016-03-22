package object packagesandimports {
	def showFruit(fruit: Fruit) {
		import fruit._
		println(name + "'s are" + color)
	}
}