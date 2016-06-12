package basic.Akka

import akka.actor.Actor
import akka.event.Logging

class MyActor extends Actor {
	val log = Logging(context.system, this)

	// Actorを継承する場合はreceiveメソッドを実装する必要あり
	def receive = {
		case num: Int => log.info("Int   : " + num)
		case str: String => log.info("String: " + str)
		case _ => log.info("invalid number")
	}
}