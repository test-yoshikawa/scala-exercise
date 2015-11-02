package scalableProgramming.chapter20

/**
 * @author Yuki Yoshikawa
 */
class Dog extends Animal {
	type SuitableFood = DogFood

	override def eat(food: DogFood) { println("eat dog!")}
}