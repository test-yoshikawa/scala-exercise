package scalableProgramming.chapter18

/**
 * ミュータブルな銀行口座クラス
 * 今までの操作によって影響を受ける⇒ステートフルオブヘクト
 *
 * @author Yuki Yoshikawa
 */
class BankAccount {
	private var bal: Int = 0
	def balance: Int = bal

	/**
	 * 預金をする
	 */
	def deposit(amount: Int) {
		require(amount > 0)
		bal += amount
	}

	/**
	 * 引き落とす
	 */
	def withdraw(amount: Int): Boolean = {
		if (amount > bal) false
		else {
			bal -= amount
			true
		}
	}
}