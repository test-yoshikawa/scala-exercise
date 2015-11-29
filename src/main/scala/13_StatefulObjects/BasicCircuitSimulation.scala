package StatefulObjects.simulation

/**
 * 基本論理ゲートの3つの回路（NOT, AND, OR）を定義する抽象クラス
 */
abstract class BasicCircuitSimulation extends Simulation {
	def InverterDelay: Int 	// NOT(Inverter)回路: 信号を反転させる
	def AndGateDelay: Int 	// AND回路: 入力の論理積を出力とする
	def OrGateDelay: Int 		// OR回路: 入力の論理和を出力とする

	/**
	 * 配線を扱うクラス
	 */
	class Wire {
		private var sigVal = false	// 配線上の現在の信号
		private var actions: List[Action] = List()
		def getSignal = sigVal
		def setSignal(s: Boolean) =
			if (s != sigVal) {
				sigVal = s
				actions foreach (_ ())	// actionsの個々の要素に "_ ()" 関数を適用する
			}

		/**
		 * 配線のアクションに引数のActionを付属させる
		 * 最初に実行されるが、その後は配線の信号が変わるたびに実行される
		 */
		def addAction(a: Action) = {
			actions = a:: actions
			a()
		}
	}

	/**
	 * Inverter回路の追加
	 * 出力値が入力値の逆に設定される
	 */
	def inverter(input: Wire, output: Wire) {
		def invertAction() {
			val inputSig = input.getSignal
			afterDelay(InverterDelay) {
				output setSignal !inputSig
			}
		}
		input addAction invertAction
	}

	/**
	 * AND回路の追加
	 */
	def andGate(o1: Wire, o2: Wire, output: Wire) {
		def andAction() {
			val o1Sig = o1.getSignal
			val o2Sig = o2.getSignal
			afterDelay(AndGateDelay) {
				output setSignal (o1Sig & o2Sig)
			}
		}
		o1 addAction andAction
		o2 addAction andAction
	}

	/**
	 * OR回路の追加
	 */
	def orGate(o1: Wire, o2: Wire, output: Wire) {
		def orAction() {
			val o1Sig = o1.getSignal
			val o2Sig = o2.getSignal
			afterDelay(OrGateDelay) {
				output setSignal (o1Sig | o2Sig)
			}
		}
		o1 addAction orAction
		o2 addAction orAction
	}

	/**
	 * シミュレーションの出力
	 */
	def probe(name: String, wire: Wire) {
		def probeAction() {
			println(name + " " + currentTime + " new-value = " + wire.getSignal)
		}
		wire addAction probeAction
 	}
}