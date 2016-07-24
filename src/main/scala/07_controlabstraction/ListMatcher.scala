package controlabstraction

/** List パターンマッチ */
object ListMatcher {

  /** リストの中に負数が含まれているか判定
    *
    * @param nums List[Int]
    * @return true: あり, false: なし
    */
  def containsNeg(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums) {
      if (num < 0) exists = true
    }
    exists
  }

  /** （簡易版）リストの中に負数が含まれているか判定
    *
    * @param nums List[Int]
    * @return true: あり, false: なし
    */
  def containsNegByFunction(nums: List[Int]) = nums.exists(_ > 0)

  /** リストの中に偶数が含まれているか判定
    *
    * @param nums List[Int]
    * @return true: あり, false: なし
    */
  def containsOdd(nums: List[Int]): Boolean = {
    var exists = false
    for (num <- nums) {
      if (num % 2 == 1) exists = true
    }
    exists
  }

  /** （簡易版）リストの中に偶数が含まれているか判定
    *
    * @param nums List[Int]
    * @return true: あり, false: なし
    */
  def containsOddByFunction(nums: List[Int]) = nums.exists(_ % 2 == 1)
}