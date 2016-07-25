package companion_object.checksum

/** Applicationトレイトを利用したアプリケーション */
object MainExtendsApp extends App {
  println("execute ChecksumAccumulator")
  println("Chapter4 => " + CheckSumAccumulator.calculate("Chapter4"))
  println("Chapter4.1 => " + CheckSumAccumulator.calculate("Chapter4.1"))
  println("Chapter4 => " + CheckSumAccumulator.calculate("Chapter4"))
}