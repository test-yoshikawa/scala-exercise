package ControlAbstraction

/**
 * List パターンマッチ
 */
object ListMatcher {

	def containsNeg(nums: List[Int]): Boolean = {
		var exists = false
		for (num <- nums) {
			if (num < 0) exists = true
		}
		exists
	}
	// 関数を利用することで簡潔に定義でできる
	def containsNegByFunction(nums: List[Int]) = nums.exists(_ > 0)

	def containsOdd(nums: List[Int]): Boolean = {
		var exists = false
		for (num <- nums) {
			if (num % 2 == 1) exists = true
		}
		exists
	}
	def containsOddByFunction(nums: List[Int]) = nums.exists(_ % 2 == 1)
}