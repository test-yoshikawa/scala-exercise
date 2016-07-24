package packagesandimports

/** フルーツのメニュー表示 */
object PrintMenu {

  /** メイン実行
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) {
    for (fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}