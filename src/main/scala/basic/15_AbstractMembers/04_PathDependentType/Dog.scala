package basic.AbstractMembers

class Dog extends Animal {
	type SuitableFood = DogFood

	override def eat(food: DogFood) { println("eat dog!")}
}