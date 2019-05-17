import org.scalatest._
import org.scalacheck.Gen


class storagetests extends UnitSpec {
  val EX : Map[Int, Tag] = 
    (for (i <- (1 to 6).toList) yield {
      object T extends Tag ("storageex%02d".format (i))
      (i, T)
    }).toMap

  import storage._

  property ("EX01 - constant5", EX (1)) {
    assert ({ 
      val r1 : Int = constant5 ()
      val r2 : Int = constant5 ()
      (r1, r2)
    } === (5, 5)
    )
  }

  property ("EX02 - constant", EX (2)) {
    assert ({ 
      val k1 : () => Int = constant (1)
      val k2 : () => Int = constant (2)
      val r1 : Int = k1 ()
      val r2 : Int = k1 ()
      val r3 : Int = k2 ()
      val r4 : Int = k2 ()
      val r5 : Int = k2 ()
      val r6 : Int = k1 ()
      (r1, r2, r3, r4, r5, r6)
    } === (1, 1, 2, 2, 2, 1)
    )
  }

  property ("EX03 - counter0", EX (3)) {
    assert ({ 
      val r1 : Int = counter0 ()
      val r2 : Int = counter0 ()
      val r3 : Int = counter0 ()
      (r1, r2, r3)
    } === (0, 1, 2)
    )
  }

  property ("EX04 - counter", EX (4)) {
    assert ({ 
      val k1 : () => Int = counter (1)
      val k2 : () => Int = counter (2)
      val r1 : Int = k1 ()
      val r2 : Int = k1 ()
      val r3 : Int = k2 ()
      val r4 : Int = k2 ()
      val r5 : Int = k2 ()
      val r6 : Int = k1 ()
      (r1, r2, r3, r4, r5, r6)
    } === (1, 2, 2, 3, 4, 3)
    )
  }

  property ("EX05 - getAndSet", EX (5)) {
    assert ({ 
      val (get1, set1) : (() => Int, Int => Unit) = getAndSet (1)
      val (get2, set2) : (() => Int, Int => Unit) = getAndSet (2)
      val r1 : Int = get1 ()
      val r2 : Int = get1 ()
      set1 (10)
      val r3 : Int = get1 ()
      val r4 : Int = get1 ()
      val r5 : Int = get2 ()
      val r6 : Int = get2 ()
      set2 (20)
      val r7 : Int = get2 ()
      val r8 : Int = get1 ()
      (r1, r2, r3, r4, r5, r6, r7, r8)
    } === (1, 1, 10, 10, 2, 2, 20, 10)
    )
  }

  property ("EX06 - getAndSetSpy", EX (6)) {
    assert ({
      val (spy1, getAndSet1) : (() => Int, Int => (() => Int, Int => Unit)) = getAndSetSpy ()
      val (spy2, getAndSet2) : (() => Int, Int => (() => Int, Int => Unit)) = getAndSetSpy ()
      val (get1a, set1a) : (() => Int, Int => Unit) = getAndSet1 (0)
      val (get1b, set1b) : (() => Int, Int => Unit) = getAndSet1 (0)
      val (get2a, set2a) : (() => Int, Int => Unit) = getAndSet2 (0)
      val (get2b, set2b) : (() => Int, Int => Unit) = getAndSet2 (0)
      set1a(10)
      set1b(11)
      set2a(20)
      set2b(21)
      val r1 : Int = spy1() //failed
      val r2 : Int = spy2() // failed 
      val r1a : Int = get1a ()
      val r1b : Int = get1b ()
      val r2a : Int = get2a ()
      val r2b : Int = get2b ()
      set1a(100)
      val r3 : Int = spy1()
      val r4 : Int = spy2()
      set1b(101)
      val r5 : Int = spy1()
      val r6 : Int = spy2()
      set2a(200)
      val r7 : Int = spy1()
      val r8 : Int = spy2()
      set2b(201)
      val r9 : Int = spy1()
      val r10 : Int = spy2()
      val s1a : Int = get1a ()
      val s1b : Int = get1b ()
      val s2a : Int = get2a ()
      val s2b : Int = get2b ()
      (r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r1a, r1b, r2a, r2b, s1a, s1b, s2a, s2b)
    } === (4,4,5,5,6,6,7,7,8,8,10,11,20,21,100,101,200,201)
    )
  }

}
