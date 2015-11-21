package PackagesAndImports {
	package navigation {
		// chapter13.navigationパッケージ
		class Navigator {
			// 同じパッケージ内の場合はプレフィックス不要
			val map = new StartMap
		}
		class StartMap
	}
	class Ship {
		// プレフィックス必要
		val nav = new navigation.Navigator
	}
	package fleets {
		class Fleet {
			def addShip() { new Ship }
			// 外部パッケージのシンボルには自動的にアクセスできないためコンパイルエラー
			// val nav = new Navigator
		}
	}
}

