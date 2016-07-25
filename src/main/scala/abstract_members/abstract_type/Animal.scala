package abstract_members.abstract_type

/** Amnimal抽象クラス */
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}