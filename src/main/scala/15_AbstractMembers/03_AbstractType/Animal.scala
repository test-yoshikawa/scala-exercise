package abstractmembers

/** Amnimal抽象クラス */
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}