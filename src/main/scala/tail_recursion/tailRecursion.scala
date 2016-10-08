package tail_recursion

/** 末尾再帰サンプル
  *
  * - 末尾再帰の関数はStackOverFlowを回避できる
  *
  * - 末尾再帰でない再帰関数はStackOverFlowが起こる場合がある
  *
  */
object TailRecursion {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]): Unit = {
    println("1. ある自然数を引数に取り、当該自然数以下の自然数の合計を表示")
    try {
      // StackOverFlowが起こる例
      println("sumNaturalNum(99999): " + sumNaturalNum(99999))
    } catch {
      case e: StackOverflowError => println("sumNaturalNum(99999): StackOverFlow")
    }
    println("sumNaturalNumTailRec(99999): " + sumNaturalNumTailRec(99999))

    println()
    println("2. Q1の階乗を表示")
    println("factorial(9): " + factorialNaturalNum(9))

    println()
    println("3. n項目目のフィボナッチ数を表示")
    println("fibonacci(5): " + fibonacci(5))

    println()
    println("4. List[Int]の全ての要素の合計を表示")
    println("sumElem(List(1, 2, 3, 4)): " + sumElem(List(1, 2, 3, 4)))
    println("sumElem(1 :: 2 :: 3 :: 4 :: Nil): " + sumElem(1 :: 2 :: 3 :: 4 :: Nil))

    println()
    println("5. List[Int]の全ての要素を掛けた結果を表示")
    println("productElem(List(1, 2, 3, 4)): " + productElem(List(1, 2, 3, 4)))
    println("productElem(1 :: 2 :: 3 :: 4 :: Nil): " + productElem(1 :: 2 :: 3 :: 4 :: Nil))

    println()
    println("6. List[Int]の要素の中で最大値を表示")
    println("maxElem(List(1, 3, 4, 2, 23, 3)): " + maxElem(List(1, 3, 4, 2, 23, 3)))
  }

  /**
    * 引数の自然以下の自然数の合計を返す
    * f(1) = 1
    * f(2) = 1 + 2
    * f(3) = 1 + 2 + 3
    * f(4) = 1 + 2 + 3 + 4
    * ...
    * f(n) = f(n - 1) + n
    *
    * @param n 自然数
    * @return 自然数以下の自然数合計
    */
  def sumNaturalNum(n: Int): Int = {
    if(n == 1) 1
    else n + sumNaturalNum(n - 1)
  }

  /** 引数の自然以下の自然数の合計を返す（末尾再帰）
    *
    * @param n 自然数
    * @return 自然数以下の自然数合計
    */
  def sumNaturalNumTailRec(n: Int): Int = {
    def sum(m: Int, num: Int): Int = {
      if (m == 0) num
      else sum(m - 1, m + num)
    }
    sum(n, 0)
  }

  /** 引数の自然数の階乗を返す（末尾再帰）
    *
    * @param n 自然数
    * @return nの階乗
    */
  def factorialNaturalNum(n: Int): Int = {
    def factorial(m: Int, num: Int): Int ={
      if (m == 0) num
      else factorial(m - 1, m * num)
    }
    factorial(n, 1)
  }

  /** フィボナッチ数を返す（末尾再帰）：1,1,2,3,5,8,13,21,34,...
    *
    * @param n n項目
    * @return n項目目のフィボナッチ数
    */
  def fibonacci(n: Int): Int = {
//    if(n == 0 || n == 1) 1
//    else fibonacci(n - 2) + fibonacci(n - 1)
    def fib(i: Int, num1: Int, num2: Int): Int = {
      if(i == 0) num1
      else fib(i - 1, num1 + num2, num1)
    }
    fib(n, 1, 0)
  }

  /** List[Int]の全ての要素の合計を返す
    *
    * @param ints List[Int]
    * @return 全ての要素の合計
    */
  def sumElem(ints: List[Int]): Int = {
    def sum(nums: List[Int], num: Int): Int = nums match {
      case Nil => num
      case head :: tail => sum(tail, head + num)
    }
    sum(ints, 0)
  }

  /** List[Int]の全ての要素を掛けた結果を返す
    *
    * @param ints List[Int]
    * @return 全ての要素を掛けた結果
    */
  def productElem(ints: List[Int]): Int = {
    def product(nums: List[Int], num: Int): Int = nums match {
      case Nil => num
      case head :: tail => product(tail, head * num)
    }
    product(ints, 1)
  }

  def maxElem(ints: List[Int]): Int = {
    def max(nums: List[Int], num: Int): Int = nums match {
      case Nil => num
      case head :: tail => {
        val tmp = if (head > num) head else num
        max(tail, tmp)
      }
    }
    max(ints, 0)
  }
}
