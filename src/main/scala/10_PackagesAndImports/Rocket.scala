package packagesandimports

/** 可視性とコンパニオンオブジェクト */
class Rocket {
  import Rocket.fuel

  /** GoHomeする必要があるかどうか
    *
    * @return true: go home, false: pick a star
    */
  private def canGoHomeAgain = fuel > 30
}

/** ロケット */
object Rocket {
  private var fuel = 20

  /** 「go home」or「pick a star」
    *
    * @param rocket Rocket
    */
  def chooseStrategy(rocket: Rocket) {
    if (rocket.canGoHomeAgain)
      goHome()
    else
      pickAStar()
  }

  /** go home */
  def goHome() {
    fuel = fuel - 30
    println("go home     : " + fuel)
  }

  /** pick a star */
  def pickAStar() {
    fuel = fuel + 2
    println("pick a star : " + fuel)
  }
}