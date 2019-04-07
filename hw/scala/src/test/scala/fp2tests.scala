import org.scalatest._
import org.scalacheck.Gen


class fp2tests extends UnitSpec {
  val EX : Map[Int, Tag] = 
    (for (i <- (1 to 10).toList) yield {
      object T extends Tag ("fp2ex%02d".format (i))
      (i, T)
    }).toMap

  import fp2._

  property ("EX01 - map", EX (1)) {
    assert (map (Nil, (n:Int) => n + 1) === Nil)
    assert (map ((1 to 5).toList, (n:Int) => n + 1) === (2 to 6).toList)
  }

  property ("EX02 - filter", EX (2)) {
    assert (filter (Nil, (n:Int) => false) === Nil)
    assert (filter (Nil, (n:Int) => true) === Nil)
    assert (filter ((1 to 5).toList, (n:Int) => false) === Nil)
    assert (filter ((1 to 5).toList, (n:Int) => true) === (1 to 5).toList)
    assert (filter ((1 to 5).toList, (n:Int) => n % 2 === 1) === List (1,3,5))
  }

  property ("EX03 - append", EX (3)) {
    assert (append (            Nil,              Nil) === Nil)
    assert (append (            Nil, (6 to 10).toList) === (6 to 10).toList)
    assert (append ((1 to 5).toList,              Nil) === (1 to 5).toList)
    assert (append ((1 to 5).toList, (6 to 10).toList) === (1 to 10).toList)
  }

  property ("EX04 - flatten", EX (4)) {
    assert (flatten (Nil) === Nil)
    assert (flatten (List ((1 to 5).toList)) === (1 to 5).toList)
    assert (flatten (List ((1 to 5).toList, (6 to 10).toList)) === (1 to 10).toList)
    assert (flatten (List ((1 to 5).toList, (6 to 10).toList, (11 to 15).toList)) === (1 to 15).toList)
  }

  property ("EX05 - foldLeft", EX (5)) {
    def f (s : String, n : Int) : String = s + "[" + n + "]"
    assert (foldLeft (Nil, "@", f) === "@")
    assert (foldLeft ((1 to 3).toList, "@", f) === "@[1][2][3]")
  }

  property ("EX06 - foldRight", EX (6)) {
    def f (n : Int, s : String) : String = s + "[" + n + "]"
    assert (foldRight (Nil, "@", f) === "@")
    assert (foldRight ((1 to 3).toList, "@", f) === "@[3][2][1]")
  }

  property ("EX07 - joinTerminateRight", EX (7)) {
    assert (joinTerminateRight (Nil, ";") === "")
    assert (joinTerminateRight (List ("a"), ";") === "a;")
    assert (joinTerminateRight (List ("a","b","c","d"), ";") === "a;b;c;d;")
  }

  property ("EX08 - joinTerminateLeft", EX (8)) {
    assert (joinTerminateLeft (Nil, ";") === "")
    assert (joinTerminateLeft (List ("a"), ";") === "a;")
    assert (joinTerminateLeft (List ("a","b","c","d"), ";") === "a;b;c;d;")
  }

  property ("EX09 - firstNumGreaterThan", EX (9)) {
    assert (firstNumGreaterThan (5, List (4, 6, 8, 5)) === 6)
    assert (firstNumGreaterThan (7, List (4, 6, 8, 5)) === 8)
    assert (firstNumGreaterThan (4, List (4, 6, 8, 5)) === 4)
  }

  property ("EX10 - firstIndexNumGreaterThan", EX (10)) {
    assert (firstIndexNumGreaterThan (5, List (4, 6, 8, 5)) === 1)
    assert (firstIndexNumGreaterThan (7, List (4, 6, 8, 5)) === 2)
    assert (firstIndexNumGreaterThan (4, List (4, 6, 8, 5)) === 0)
  }
}
