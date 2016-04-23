package basic.firststep

/**
 * Hello　World!
 */
object Hello {
	def main(args: Array[String]) {
		println("Hello, world, from a script")

    println("max(3, 5): " + max(3, 5))
	}

  def max(x: Int, y: Int) = if( x > y) x else y
}