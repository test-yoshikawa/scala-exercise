package basic.AbstractMembers

abstract class Animal {
	type SuitableFood <: Food
	def eat(food: SuitableFood)
}