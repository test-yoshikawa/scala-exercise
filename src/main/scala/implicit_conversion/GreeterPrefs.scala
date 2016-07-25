package implicit_conversion

/** GreeterPrefsオブジェクト */
object GreeterPrefs {
  implicit val prompt = new PreferredPrompt("Yes, implicit master>")
  implicit val drink = new PreferredDrink("tea")
}