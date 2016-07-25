package abstract_members.initialize

/** Rationalクラス
  *
  * @param n Int
  * @param d Int
  */
class RationalClass(n: Int, d: Int) extends {
  val numerArg = n
  val denomArg = d
} with RationalTrait {

  /** Rationalの加算
    *
    * @param that RationalClass
    * @return 加算したRationalClass
    */
  def + (that: RationalClass) = new RationalClass(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
}