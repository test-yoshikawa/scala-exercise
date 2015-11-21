package Traits

import scala.collection.mutable.ArrayBuffer

/**
 * 数値型のQueue
 */
class BasicIntQueue extends IntQueue {
	private val buf = new ArrayBuffer[Int]
	def get() = buf.remove(0)
	def put(x: Int) { buf += x }
}