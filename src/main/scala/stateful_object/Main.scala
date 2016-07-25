package statefulobjects

/** ステートフルオブジェクト */
object Main {

  /** メイン処理実行用
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    // ステートフルオブジェクトのサンプル
    val account = new BankAccount
    println("==== Bank Account ====")
    println("account deposit 100 ")
    account deposit 100
    println("withdraw 80: " + (account withdraw 80))
    println("withdraw 80: " + (account withdraw 80))

    println("==== Time ====")
    val time = new Time
    println(time.hour)
    time.hour = 23
    println(time.hour)

    println("==== Thermometer ====")
    val thermometer = new Thermometer
    println("default thermometer: " + thermometer)
    thermometer.celsius = 100
    println("celsius = 100: " + thermometer)
    thermometer.fahrenheit = -40
    println("fahrenheit = -40: " + thermometer)
  }
}