package scalableProgramming.chapter20

/**
 * @author Yuki Yoshikawa
 */
abstract class Animal {
	type SuitableFood <: Food
	def eat(food: SuitableFood)
}