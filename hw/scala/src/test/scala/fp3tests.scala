import org.scalatest._
import org.scalacheck.Gen


class fp3tests extends UnitSpec {
  val EX : Map[Int, Tag] = 
    (for (i <- (1 to 10).toList) yield {
      object T extends Tag ("fp3ex%02d".format (i))
      (i, T)
    }).toMap

  import fp3._

  property ("EX01 - member", EX (1)) {
    assert (member (5, List (4, 6, 8, 5)) === true)
    assert (member (3, List (4, 6, 8, 5)) === false)
  }

  property ("EX02 - allEqual", EX (2)) {
    assert (allEqual (Nil) === true)
    assert (allEqual (List (5)) === true)
    assert (allEqual (List (5, 5, 5)) === true)
    assert (allEqual (List (6, 5, 5, 5)) === false)
    assert (allEqual (List (5, 5, 6, 5)) === false)
    assert (allEqual (List (5, 5, 5, 6)) === false)
  }

  val test1 = List ("The", "rain", "in", "Spain", "falls", "mainly", "on", "the", "plain.")
  val test2 = List (1,1,2,3,3,3,4,4,5,6,7,7,8,9,2,2,2,9)

  property ("EX03 - stringLengths", EX (3)) {
    assert (stringLengths (Nil) === Nil)
    assert (stringLengths (test1) === test1.zip (List (3, 4, 2, 5, 5, 6, 2, 3, 6)))
  }

  property ("EX04 - delete1", EX (4)) {
    assert (delete1 (1, Nil) === Nil)
    assert (delete1 ("the", List ("the","the","was","a","product","of","the","1980s")) === List ("was","a","product","of","1980s"))
  }

  property ("EX05 - delete2", EX (5)) {
    assert (delete2 (1, Nil) === Nil)
    assert (delete2 ("the", List ("the","the","was","a","product","of","the","1980s")) === List ("was","a","product","of","1980s"))
  }

  property ("EX06 - delete3", EX (6)) {
    assert (delete3 (1, Nil) === Nil)
    assert (delete3 ("the", List ("the","the","was","a","product","of","the","1980s")) === List ("was","a","product","of","1980s"))
  }

  property ("EX07 - removeDupes1", EX (7)) {
    assert (removeDupes1 (Nil) === Nil)
    assert (removeDupes1 (test2) === List (1,2,3,4,5,6,7,8,9,2,9))
  }

  property ("EX08 - removeDupes2", EX (8)) {
    assert (removeDupes2 (Nil) === Nil)
    assert (removeDupes2 (test2) === List ((2,1),(1,2),(3,3),(2,4),(1,5),(1,6),(2,7),(1,8),(1,9),(3,2),(1,9)))
  }

  property ("EX09 - splitAt", EX (9)) {
    assert (splitAt (7, (1 to 15).toList) === ((1 to 7).toList, (8 to 15).toList))
    assert (splitAt (1, (1 to 15).toList) === ((1 to 1).toList, (2 to 15).toList))
    assert (splitAt (0, (1 to 15).toList) === (List (), (1 to 15).toList))
    assert (splitAt (-1, (1 to 15).toList) === (List (), (1 to 15).toList))
    assert (splitAt (15, (1 to 15).toList) === ((1 to 15).toList, List ()))
    assert (splitAt (16, (1 to 15).toList) === ((1 to 15).toList, List ()))
  }

  property ("EX10 - allDistinct", EX (10)) {
    assert (allDistinct (Nil) === true)
    assert (allDistinct (List (1,2,3,4,5)) === true)
    assert (allDistinct (List (1,2,3,4,5,1)) === false)
    assert (allDistinct (List (1,2,3,2,4,5)) === false)
  }
}
