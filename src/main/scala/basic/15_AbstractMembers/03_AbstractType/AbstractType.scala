package basic.AbstractMembers

 object AbstractType {

 	def main(args: Array[String]): Unit = {
 		val cow = new Cow();
 		val grass = new Grass();
 		val fish = new Fish();
 		cow.eat(grass)		// OK
 		// cow.eat(fish)	// コンパイルエラー

 		val dog = new Dog()
 		dog eat (new dog.SuitableFood)
 		// dog eat (new cow.SuitableFood)	// コンパイルエラー
 	}
 }