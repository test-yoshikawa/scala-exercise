package practice

/**
 * Q1. 10進数、2進数、8進数のいずれで表現しても回文数となる数のうち、
 * 10進数の10以上で最小の値を求めてください
 */
object Kaibun {
  def main(args: Array[String]) = {
    var i = 10
    var checkFlag = true
    var binary = ""
    var octal = ""
    var num = ""

    while(checkFlag) {
      num = i.toString            // 10進数
      binary = i.toBinaryString   // 2進数
      octal = i.toOctalString     // 8進数
      // 回文数の判定
      if (num == num.reverse &&
          binary == binary.reverse &&
          octal == octal.reverse) checkFlag = false

      i = i + 1
    }
    println("kaibun minimum value: " + (i - 1))
    println("binary: " + binary)
    println("octal: " + octal)
  }
}