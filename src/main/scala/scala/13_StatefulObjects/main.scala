package scalableProgramming.chapter18

/**
 * @author Yuki Yoshikawa
 */
object main {

	def main(args: Array[String]) {
		// ステートフルオブジェクトのサンプル
		val account = new BankAccount
		println("account deposit 100 ")
		account deposit 100
		println("withdraw 80: " + (account withdraw 80))
		println("withdraw 80: " + (account withdraw 80))
	}
}