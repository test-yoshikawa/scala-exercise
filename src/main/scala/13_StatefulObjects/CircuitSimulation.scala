package statefulobjects.simulation

/** 半加算器と全加算器のメソッド定義を含むシミュレーションクラス */
abstract class CircuitSimulation extends BasicCircuitSimulation {

  /** 半加算器
    *
    * @param a Wire
    * @param b Wire
    * @param s Wire
    * @param c Wire
    */
  def halfAdder(a: Wire, b: Wire, s: Wire, c: Wire) {
    val d, e = new Wire
    orGate(a, b, d)
    andGate(a, b, c)
    inverter(c, e)
    andGate(d, e, s)
  }

  /** 全加算器
    *
    * @param a Wire
    * @param b Wire
    * @param cin Wire
    * @param sum Wire
    * @param cout Wire
    */
  def fullAdder(a: Wire, b: Wire, cin: Wire, sum: Wire, cout: Wire) {
    val s, c1, c2 = new Wire
    halfAdder(a, cin, s, c1)
    halfAdder(b, s, sum, c2)
    orGate(c1, c2, cout)
  }
}