package scalableProgramming.chapter20

/**
 * @author Yuki Yoshikawa
 */
class Cow extends Animal {
	type SuitableFood = Grass
	override def eat(food: Grass) { println("eat grass!") }  // 抽象型でモデリングをしない場合はサブクラスでもコンパイルエラーになる
}