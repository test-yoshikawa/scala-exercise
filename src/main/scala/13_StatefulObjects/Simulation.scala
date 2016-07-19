package statefulobjects.simulation

/**
 * シミュレーションのフレームワークを定義する抽象クラス
 */
abstract class Simulation {
	type Action = () => Unit	// 空パラメータリストをとり、Unitを返す手続き型の定義（Simulationクラスの型メンバー）

	case class WorkItem(time: Int, action: Action)	// 作業項目の定義

	private var curtime = 0	// 現在時

	def currentTime: Int = curtime	// 現在時を返す

	private var agenda: List[WorkItem] = List()	// 予定表

	/**
	 * agendaリストに追加する
	 */
	private def insert(ag: List[WorkItem], item: WorkItem): List[WorkItem] = {
		if(ag.isEmpty || item.time < ag.head.time) item :: ag
		else ag.head :: insert(ag.tail, item)
	}

	/**
	 * 予定表に追加する
	 */
	def afterDelay(delay: Int)(block: => Unit) {
		val item = WorkItem(currentTime + delay, () => block)
		agenda = insert(agenda, item)
	}

	/**
	 * 次の作業項目を実行する（前回の作業は取り除かれる）
	 */
	private def next() {
		(agenda: @unchecked) match {
			case item :: rest =>
				agenda = rest
				curtime = item.time
				item.action()
		}
	}

	def run() {
		afterDelay(0) {
			println("***  simulation started, time = " + currentTime + " ***")
		}
		while(!agenda.isEmpty) next()
	}
}