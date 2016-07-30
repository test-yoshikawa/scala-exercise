package reflection

import scala.reflect.runtime.{universe => ru}

/** Runtime Reflection サンプル */
object RuntimeReflection {

  case class Person(name: String)

  case class Purchase(name: String, orderNumber: Int, shipped: Boolean)

  class E {
    type T
    val x: Option[T] = None
  }

  class C extends E

  class D extends C

  /** メイン処理
    *
    * @param args コマンドライン引数
    */
  def main(args: Array[String]) = {
    println()
    val list = List(1, 2, 3)
    val listType = getTypeTag(list).tpe
    println(list + ": " + listType)

    // （非推奨）Typeのinstanceをinspect（調査）する
    val decls = listType.declarations.take(10)
    println(list + " inspect: " + decls)
    println()

    //=======================================
    // ランタイムのインスタンス化
    //=======================================
    // 現在のClassLoaderで読み込まれた（Personクラスを含む）すべてのクラスや型をアクセス可能とするmirrorを取得する
    val m = ru.runtimeMirror(getClass.getClassLoader)

    // PersonクラスのClassMirrorを取得する
    val classPerson = ru.typeOf[Person].typeSymbol.asClass
    println(classPerson)
    val cm = m.reflectClass(classPerson)
    println(cm)
    // ClassMirrorはPersonクラスのConstructorへのアクセスを提供する
    val ctor = ru.typeOf[Person].declaration(ru.nme.CONSTRUCTOR).asMethod

    // PersonクラスのConstructorのシンボルは実行時ユニバースruを用いてPerson型の宣言から照会できる
    val ctom = cm.reflectConstructor(ctor)
    val p = ctom("Yoshikawa")
    println(p)
    println()

    //=======================================
    // ランタイム型のメンバへのアクセスと呼び出し
    //=======================================
    val p2 = Purchase("Yuki Yoshikawa", 23819, false)
    println(p2)
    println()

    // Purchase p の shipped フィールドをリフレクションを使って get/set を行う
    val m2 = ru.runtimeMirror(p2.getClass.getClassLoader)
    val shippingTermSymbol = ru.typeOf[Purchase].declaration(ru.TermName("shipped")).asTerm
    val im = m2.reflect(p2)
    val shippingFieldMirror = im.reflectField(shippingTermSymbol)
    println("Purchase.shipped get: " + shippingFieldMirror.get)
    println("Purchase.shipped set: true")
    shippingFieldMirror.set(true)
    println("Purchase.shipped get: " + shippingFieldMirror.get)
    println()

    //=======================================
    // ランタイム型のメンバへのアクセスと呼び出し
    //=======================================
    val c = new C { type T = String}
    val d = new D { type T = String }
    println(c)
    println(d)

    // java.lang.Classを取得して、dのランタイムクラスがcのランタイムクラスのサブクラスかどうか判定
    val isAssignable = c.getClass.isAssignableFrom(d.getClass)
    println("c isAssignableFrom d: " + isAssignable)
    // Scalaリフレクションを利用することで、正確なランタイム型を取得できる
    println("isAssignableFrom For Scala Reflection: " + isAssignableScala(d, c))
    println()
  }

  /** 型タグ（TypeTag）を取得する
    *
    * @param obj オブジェクト
    * @tparam T 型
    * @return 型タグ
    */
  def getTypeTag[T: ru.TypeTag](obj: T) = ru.typeTag[T]

  /** xはyのサブクラスかどうか判定
    *
    * java.lang.Classによる継承関係の判定は継承してもfalseになる。
    *
    * 理由はScalaコンパイラがそれぞれのクラスに匿名のサブクラスを作成しているため。
    *
    * Scala Reflection を利用することで正確なランタイム型を取得できる
    *
    * @param x サブクラス
    * @param y スーパークラス
    * @tparam T サブクラス型
    * @tparam S スーパークラス型
    * @return true: 継承関係, false: 継承関係でない
    */
  def isAssignableScala[T: ru.TypeTag, S: ru.TypeTag](x: T, y: S): Boolean = {
    val leftTag = ru.typeTag[T]
    val rightTag = ru.typeTag[S]
    leftTag.tpe <:< rightTag.tpe
  }
}
