package function_style.rational

/** 有理数（Rational Number）クラス */
class Rational(n: Int, d: Int) extends Ordered[Rational] {
  // 事前条件( require(...) )falseの場合はIllegalArgumentExceptionをスローする
  require(d != 0) // これより上の処理は実行される
  private val g = gcd(n.abs, d.abs) // 最大公約数
  val number: Int = n / g       // 数値（分子）
  val denominator: Int = d / g  // 分母

  override def toString = number + "/" + denominator

  /** 補助Constructor
    *
    * - 整数のRationalを作成する
    *
    * @param n 整数
    * @return constructor
    */
  def this(n: Int) = this(n, 1)

  /** 最大公約数を求める
    *
    * @param a 数値
    * @param b 数値
    * @return 最大公約数
    */
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  /** 指定した引数より小さいかどうか判定する
    *
    * @param that 分数
    * @return true: 小さい, false: 大きい
    */
  def lessThan(that: Rational) =
    // that.n, that.dを参照できないためフィールドにして参照する
    this.number * that.denominator < that.number * this.denominator

  /** 引数より大きいかどうか判定する
    *
    * @param that 分数
    * @return true: 大きい, false: 小さい
    */
  def max(that: Rational) = if (this.lessThan(that)) that else this

  /** 分数の加算
    *
    * @param that 分数（Rational）
    * @return 計算結果
    */
  def add(that: Rational): Rational =
    new Rational(number * that.denominator + that.number + denominator, denominator * that.denominator)

  /** 分数の加算
    *
    * @param i 整数
    * @return 計算結果
    */
  def + (i:Int): Rational =
    new Rational(number + i * denominator, denominator)

  /** 分数の加算（overload）
    *
    * @param that 分数
    * @return 計算結果
    */
  def + (that: Rational): Rational =
    new Rational(number * that.denominator + that.number + denominator, denominator * that.denominator)

  /** 分数の減算
    *
    * @param i 整数
    * @return 計算結果
    */
  def - (i:Int): Rational =
    new Rational(number - i * denominator, denominator)

  /** 分数の減算
    *
    * @param that 分数
    * @return 計算結果
    */
  def - (that: Rational): Rational =
    new Rational(number * that.number, denominator * that.denominator)

  /** 分数の乗算
    *
    * @param i 整数
    * @return 計算結果
    */
  def * (i: Int): Rational =
    new Rational(number * i, denominator)

  /** 分数の乗算
    *
    * @param that 分数
    * @return 計算結果
    */
  def * (that: Rational): Rational =
    new Rational(number * that.number, denominator *  that.denominator)

  /** 分数の除算
    *
    * @param that 分数
    * @return 計算結果
    */
  def / (that: Rational): Rational =
    new Rational(number * that.denominator, denominator * that.number)

  /** 分数の比較
    *
    * - Orderedトレイトをミックスインすれば比較演算子（<, >, <= >=）の定義はcompere メソッドで対応できる
    *
    * @param that 分数
    * @return `x` where:
    *
    *   - `x < 0` when `this < that`
    *
    *   - `x == 0` when `this == that`
    *
    *   - `x > 0` when  `this > that`
    */
  def compare(that: Rational) = (this.number * that.denominator) - (that.number * this.denominator)
}