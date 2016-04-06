package slickPractice

import slick.codegen.SourceCodeGenerator

/**
 * テーブル定義よりクラス自動出力（Tables.scalaが作成される）
 */
object CodeGen extends App {
  val slickDriver = "slick.driver.PostgresDriver"
  val jdbcDrive = "org.postgresql.Driver"
  val url = "jdbc:postgresql://localhost/archive"
  val outputDir = "src/main/scala"
  val pkg = "slickPractice"
  val user = "postgres"
  val password = "postgres"

  SourceCodeGenerator.main(
    Array(slickDriver, jdbcDrive, url, outputDir, pkg, user, password)
  )
}
