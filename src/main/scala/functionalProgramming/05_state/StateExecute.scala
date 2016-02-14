package functionalProgramming

object StateExecute {

	def main(args: Array[String]): Unit = {
		val rng = SimpleRNG(42)

		// rng1~5のnextIntは常に同じInt値と新しいRNGが返される
		val (n1, rng2) = rng.nextInt
		println("n1:   " + n1)
		println("rng2: " + rng2)
		val (n2, rng3) = rng2.nextInt
		println("n2:   " + n2)
		println("rng3: " + rng3)
		val (n3, rng4) = rng.nextInt
		println("n3:   " + n3)
		println("rng4: " + rng4)
		val (n4, rng5) = rng3.nextInt
		println("n4:   " + n4)
		println("rng5: " + rng5)
	}
}