package scalableProgramming

/**
 * @author Yuki Yoshikawa
 */
object buildinControlStructures {
  def main(args: Array[String]): Unit = {

	  val arrayS = new Array[Int](3)
	  arrayS(0) = 0
	  arrayS(1) = 1
	  arrayS(2) = 2

	  for (elem <- arrayS if elem == 1) {
	 	  println(elem)
	  }
  }
}