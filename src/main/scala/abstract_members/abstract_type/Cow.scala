package abstract_members.abstract_type

/** Cowクラス */
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: Grass) { println("eat grass!") }  // 抽象型でモデリングをしない場合はサブクラスでもコンパイルエラーになる
}