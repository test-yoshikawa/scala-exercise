package traits

trait Common {
  def showInfo()
}


trait Printable extends Common {
  def print() = println("now printing ...")
  def getInfo() = println("Print!")
  override def showInfo() = println("Print!")
}

trait Sharable extends Common {
  def share() = println("now sharing ...")
  def getInfo() = println("Share!") // 同じ名前のメソッドを記載した場合はエラーになる
  override def showInfo = println("Share!")
}

class User extends Printable with Sharable {
  // どちらかのSuperクラスのメソッドをoverrideすれば良い
  override def getInfo() = super[Printable].getInfo()
}

object Sample {
  def main(args: Array[String]): Unit = {
    val user = new User
    user.print()
    user.share()
    user.getInfo()
    user.showInfo() // １番後ろに合成されたクラス(Sharable)のメソッドが実行される
  }
}
