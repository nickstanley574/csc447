case class C (var x:Int)

object Test {
  def f (o:C) {
    o.x = 10
  }

  def main (args:Array[String]) {
    val c = C (5)
    f (c)
    println (c)
  }
}

// nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws7-argument-passing$ scala Test
// C(10) <- cbr since C was updated from 5 to 10 