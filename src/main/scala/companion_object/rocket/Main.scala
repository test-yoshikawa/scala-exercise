package companion_object.rocket

/** コンパニオンオブジェクト サンプル */
class Main {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) = {
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
