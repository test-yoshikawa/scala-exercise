package packagesandimports

object PrintMenu {
	def main(args: Array[String]) {
		for (fruit <- Fruits.menu) {
			showFruit(fruit)
		}
	}
}