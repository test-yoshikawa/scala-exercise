package packagesandimports

/**
 * インポートのサンプル
 * ・importは任意の場所に書ける
 * ・パッケージのほか、オブジェクト（シングルトンでも通常のものでも）も参照できる
 * ・インポートされたメンバーの一部の名前を変えたり、隠したりすることができる
 */
abstract class Fruit(val name: String, val color: String)

object Fruits {
	object Apple extends Fruit("apple", "red")
	object Orange extends Fruit("orange", "orange")
	object Grape extends Fruit("grape", "wine-red")

	val menu = List(Apple, Orange, Grape)

	def showFruit(fruit: Fruit) {
		import fruit._	// importは任意の場所に書ける
		println(name + "s are " + color)
	}
}