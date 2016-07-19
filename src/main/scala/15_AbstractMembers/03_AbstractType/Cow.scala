package abstractmembers

class Cow extends Animal {
	type SuitableFood = Grass
	override def eat(food: Grass) { println("eat grass!") }  // 抽象型でモデリングをしない場合はサブクラスでもコンパイルエラーになる
}