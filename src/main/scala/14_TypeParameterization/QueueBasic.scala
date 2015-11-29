package TypeParameterization

/**
 * Queueの基本形
 */
class QueueBasic[+T] private (private[this] var leading: List[T], private[this] var trailing: List[T]) {

	private def mirror() = 
		if (leading.isEmpty) {
			while(!trailing.isEmpty) {
				leading = trailing.head :: leading
				trailing = trailing.tail
			}
		}

	def head: T = {
		mirror()
		leading.head
	}
	def tail: QueueBasic[T] = {
		mirror()
		new QueueBasic(leading.tail, trailing)
	}

	def enqueue[U >: T](x: U) = new QueueBasic(leading, x :: trailing)
}