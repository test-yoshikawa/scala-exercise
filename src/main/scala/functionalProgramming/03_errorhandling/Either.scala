package functionalProgramming.errorhandling

sealed trait Either[+E, +A]{
	def map[B](f: A => B): Either[E, B] = this match {
		case Right(a) => Right(f(a))
		case Left(e) => Left(e)
	}

	def flatMap[EE >: E, B](f: A => Either[EE, B]): Either[EE, B] = this match {
		case Left(e) => Left(e)
		case Right(a) => f(a)
	}

	def orElse[EE >: E, AA >: A](b: => Either[EE, AA]): Either[EE, AA] = this match {
		case Left(_) => b
		case Right(a) => Right(a)
	}
	def map2[EE >: E, B, C](b: Either[EE, B])(f: (A, B) => C):Either[EE, C] =
		for { a <- this; b1 <- b } yield f(a,b1)
}
case class Left[+E](value: E) extends Either[E, Nothing]
case class Right[+A](value: A) extends Either[Nothing, A]

object EitherExample {

	/**
	 * リストの平均を計算する
	 * return Either[String, Double]
	 */
	def mean(xs: IndexedSeq[Double]): Either[String, Double] =
		if (xs.isEmpty) Left("mean of empty list!")
		else Right(xs.sum / xs.length)

	def main(args: Array[String]): Unit = {
		val values = IndexedSeq(1.1, 3.4, 5.0)
		println(values + " mean result: Either[String, Double] = " + mean(values))
	}
}