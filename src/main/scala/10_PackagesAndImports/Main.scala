package packagesandimports

/** パッケージオブジェクト サンプル実行用 */
object Main {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    //========================================
    // インポート　サンプル
    //========================================
    import Fruits.{_}				// Fruitsのすべてのメンバーをインポートする
    import Fruits.{Orange, Grape}	// インポートするFruitsのメンバーを指定する
    import Fruits.{Apple => _, _}	// Appleを除くFruitsのすべてのメンバーをインポートする

    // val apple = Apple	// オブジェクトのインポートをしていないためコンパイルエラー
    val orange = Orange
    val Pear = Grape

    // メンバーの一部の名前を変更できる
    import Fruits.{Apple => McIntosh}
    val apple = McIntosh

    //========================================
    // 可視性とコンパニオンオブジェクト　サンプル
    //========================================
    val rocket = new Rocket()
    Rocket.chooseStrategy(rocket)
    Rocket.chooseStrategy(rocket)
    Rocket.chooseStrategy(rocket)
    Rocket.chooseStrategy(rocket)
    Rocket.chooseStrategy(rocket)
    Rocket.chooseStrategy(rocket)
    Rocket.chooseStrategy(rocket)
    Rocket.chooseStrategy(rocket)
  }
}