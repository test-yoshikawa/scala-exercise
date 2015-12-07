package Akka

import akka.actor.{ActorSystem, Props}

object Main {

	def main(args: Array[String]) {
			val system = ActorSystem("system")
			val actor = system.actorOf(Props[HelloActor])

			actor ! "Hello"
	}
}