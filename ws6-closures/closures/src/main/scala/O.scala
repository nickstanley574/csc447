import scala.language.existentials

// 6.4 Scala Nested Classes

object O {
    def main (args:Array[String]) {
        class C (x:Int) {
            println("C")
            object P {
                println("P")
                def f() {println (args(x))}
            }
        }
        val cs:List[C] = for (i <- (0 to (args.length -1)).toList) yield new C(i)
        val ps:List[c.P.type forSome { val c:C }] = for (c <- cs) yield c.P
        ps.foreach (p => p.f)
    } 
}