package scala.PackagesAndImports

/**
 * @author Yuki Yoshikawa
 */
object main {

	def main(args: Array[String]) {
		//========================================
		// インポート　サンプル
		//========================================
		import Fruits.{_}				// Fruitsのすべてのメンバーをインポートする
		import Fruits.{Orange, Grape}	// インポートするFruitsのメンバーを指定する
		import Fruits.{Apple => _, _}	// Appleを除くFruitsのすべてのメンバーをインポートする

		// val apple = Apple	// オブジェクトのインポートをしていないためコンパイルエラー
		val orange = Orange
		val Pear = Grape

		// メンバーの一部の名前を変更できる
		import Fruits.{Apple => McIntosh}
		val apple = McIntosh
	}
}