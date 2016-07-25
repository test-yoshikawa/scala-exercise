package statefulobjects

/** mutableな銀行口座クラス
  * 
  * 今までの操作によって影響を受ける⇒ステートフルオブヘクト
  */
class BankAccount {
  private var bal: Int = 0
  def balance: Int = bal

  /** 預金する
    *
    * @param amount 金額
    */
  def deposit(amount: Int) {
    require(amount > 0)
    bal += amount
  }

  /** 引き落とす
    *
    * @param amount 金額
    * @return true: 完了, false: エラー
    */
  def withdraw(amount: Int): Boolean = {
    if (amount > bal) false
    else {
      bal -= amount
      true
    }
  }
}