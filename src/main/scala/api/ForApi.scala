package api

/** For文 サンプル
  *
 * - ファイル操作が含まれているためWindowsでの実行の場合はsbt/sbtconfig.txtに「-Dfile.encoding=UTF-8」を追加
 *
  * - 上記の対応をした場合、実行は成功するがコンソールは文字化けする
  *
 */
object ForApi {

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) = {
    println("==== for (i <- 1 to 4) ====")
    for (i <- 1 to 4) println("Iteration " + i)

    println()
    println("==== for (i <- 1 until 4) ====") // =>for (i <- 1 to 3)
    for (i <- 1 until 4) println("Iteration " + i)

    println()
    println("==== for (i <- 1 until 4)  yield i ====") // return list
    val nums = for (i <- 1 until 4)  yield i // yieldを使用することで反復結果を配列（Array型）に格納される
    println(nums.toList)

    println()
    println("==== for filter ====")
    val filesHere = (new java.io.File("./src/main/scala/api")).listFiles
    for(file <- filesHere if file.getName.endsWith(".txt"))
      println(file)

    println()
    println("==== for nesting ====")
    grep(filesHere, ".*gcd.*")

    println()
    println("==== for yield ====")

    // コレクションの作成
    def scalaFiles = for { file <- filesHere if file.getName.endsWith(".scala")} yield file
    scalaFiles.foreach(println)
  }

  /** ファイル内容の各行をリストで取得する
    *
    * @param file ファイル
    * @return List
    */
  def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

  /** patternにマッチするScalaファイルをgrepする
    *
    * @param filesHere 対象ファイル
    * @param pattern パターン
    */
  def grep(filesHere: Array[java.io.File], pattern: String) = {
    for(file <- filesHere if file.getName.endsWith(".scala");
        line <- fileLines(file) if line.trim.matches(pattern)) println(file + ": " + line.trim)

    for{
      file <- filesHere
        if file.getName.endsWith(".scala");
      line <- fileLines(file)
        trimmed = line.trim // 新しい変数（trim）にバインドすることで1度だけの計算で回数が減る
        if trimmed.matches(pattern)
      } println(file + ": " + trimmed)
  }
}