package file_io

import scala.io.Source
import java.io.{BufferedReader, FileReader}

/** ファイル読み込み サンプル */
object ReadFile {

  def main(args: Array[String]) = {
    val src = "./src/main/scala/file_io/input/sample1.txt"

    // scala.io.Sourceを使用する
    println()
    println("<< read txt by Scala.io.Source >>")
    val sampleFile1 = Source.fromFile(src, "UTF-8")
    val sampleFile2 = Source.fromFile(src, "UTF-8")
    try {
      for (line <- sampleFile1.getLines()) {
        println(line) // getLinesを呼ぶとsampleFIle1が空リストになる
      }
      println()
      println("<delete empty line>")
      sampleFile2.getLines().filter(_ != "").foreach(println)
    } finally {
      sampleFile1.close()
    }

    // バッファを経由して読み込む
    println()
    println("<< read txt by java.io.BufferedReader >>")
    openViaBuffer(src)

    println()
  }

  /** Bufferを経由してファイルを開く
    *
    * @param src
    */
  def openViaBuffer(src: String) = {
    val in = new BufferedReader(new FileReader(src))
    try {
      loop
    } finally {
      in.close
    }

    def loop() {
      val readLine = in.readLine()
      if(readLine != null) {
        println(readLine)
        loop
      }
    }
  }
}
