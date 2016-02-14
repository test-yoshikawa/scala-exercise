package functionalProgramming.errorhandling

sealed trait Option[+A] {
	def map[B](f: A => B): Option[B] = this match {
		case None => None
		case Some(a) => Some(f(a))
	}

	def flatMap[B](f: A => Option[B]): Option[B] = map(f) getOrElse None

	def getOrElse[B >: A](default: => B): B = this match {
		case None => default
		case Some(a) => a
	}

	def orElse[B >: A](ob: => Option[B]): Option[B] = this map (Some(_)) getOrElse ob

	def filter(f: A => Boolean): Option[A] = this match {
		case Some(a) if f(a) => this
		case _ => None
	}
}
case class Some[+A](get: A) extends Option[A]
case object None extends Option[Nothing]

object OptionExample {

	/**
	 * 例外を発生させる
	 */
	def failingFn(i: Int): Int = {
		// val y: Int = throw new Exception("fail!")	// この時点で例外が発生する
		try {
			val x = 42 + 5
			// x + y
			x + ((throw new Exception("fail!")): Int)	// catchされて返り値を返す
		} catch {
			case e: Exception => 43
		}
	}

	/**
	 * リストの平均を計算する
	 * return Double
	 */
	def mean(xs: Seq[Double]): Double = 
		if(xs.isEmpty) throw new ArithmeticException("mean of empty list!")
		else xs.sum / xs.length

	/**
	 * リストの平均を計算する
	 * return Option[Double]
	 */
	def meanOption(xs: Seq[Double]): Option[Double] = 
		if (xs.isEmpty) None
		else Some(xs.sum / xs.length)

	def main(args: Array[String]): Unit = {
		println(failingFn(1));
		val values = Seq(1.1, 3.4, 5.0)
		println(values + " mean result: Double = " + mean(values))
		println(values + " mean result: Option[Double] = " + meanOption(values))
	}
	
}