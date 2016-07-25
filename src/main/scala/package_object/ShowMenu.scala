package package_object

/** フルーツのメニュー表示 */
object ShowMenu {

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