package basic.Akka

import akka.actor.{ActorSystem, Props}

object Main {

	def main(args: Array[String]) {
			val system1 = ActorSystem("system1")
			val system2 = ActorSystem("system2")
			val actor1 = system1.actorOf(Props[MyActor])
			val actor2 = system1.actorOf(Props[MyActor])
			val actor3 = system2.actorOf(Props[MyActor])

			// actor1の順序は変わらないが、actor1, 2, 3は並列処理される
			for (i <- 0 until 5)  {
				actor1 ! i 							// １
				actor1 ! (i + 10)				// ２
				actor2 ! "system1 test"	// ３
				actor3 ! "system2 test"	// ４
			}
	}
}