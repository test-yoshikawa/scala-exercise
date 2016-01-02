package PackagesAndImports

/**
 * 可視性とコンパニオンオブジェクト
 */
class Rocket {
	import Rocket.fuel
	private def canGoHomeAgain = fuel > 30
}
object Rocket {
	private var fuel = 20

	def chooseStrategy(rocket: Rocket) {
		if (rocket.canGoHomeAgain)
			goHome()
		else 
			pickAStar()
	}
	def goHome() { 
		fuel = fuel - 30
		println("go home     : " + fuel)
	}
	def pickAStar() {
		fuel = fuel + 2
		println("pick a star : " + fuel)
	}
}