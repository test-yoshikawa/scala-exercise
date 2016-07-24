package abstractmembers

/** Apple抽象クラス（非推奨） */
abstract class BadApple extends Fruit {
  // def v: String   // エラー : valをdefでオーバーライトできない
  def m: String
}