package Akka

import akka.actor.Actor


class HelloActor extends Actor { 

	def receive = {
		case "Hello" => println("world!")

	}
}