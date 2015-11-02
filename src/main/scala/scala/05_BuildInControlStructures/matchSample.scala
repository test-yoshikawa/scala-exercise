package scalableProgramming.chapter07

/**
 * @author Yuki Yoshikawa
 */
object matchSample {

	def main(args: Array[String]): Unit = {
		val firstArgs = if (args.length > 0) args(0) else ""
		firstArgs match {
			case "salt" => println("pepper")
			case "chips" => println("salsa")
			case "eggs" => println("bacon")
			case _ => println("huh?")
		}

		val friend =
			firstArgs match {
				case "salt" => "pepper"
				case "chips" => "salsa"
				case "eggs" => "bacon"
				case _ => "huh?"
			}
		println(friend)
	}
}