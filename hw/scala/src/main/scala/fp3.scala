// GENERATED
/* INSTRUCTIONS
 *
 * Complete the exercises below.  For each "EXERCISE" comment, add
 * code immediately below the comment.
 *
 * Please see README.md for instructions, including compilation and testing.
 * 
 * GRADING
 * 
 * 1. Submissions MUST compile using SBT with UNCHANGED configuration and tests with no
 *    compilation errors.  Submissions with compilation errors will receive 0 points.
 *    Note that refactoring the code will cause the tests to fail.
 *
 * 2. You MUST NOT edit the SBT configuration and tests.  Altering it in your submission will
 *    result in 0 points for this assignment.
 *
 * 3. You MUST NOT use while loops or (re)assignment to variables (you can use "val" declarations,
 *    but not "var" declarations).  You must use recursion instead.
 *
 * 4. You may declare auxiliary functions if you like.
 *
 * SUBMISSION
 *
 * 1. Submit this file on D2L before the deadline.
 *
 * 2. Late submissions will not be permitted because solutions will be discussed in class.
 * 
 */

object fp3 {

  // EXERCISE 1: complete the following recursive definition of a "member" function 
  // to check whether an element "a" is a member of a list of integers "xs".
  // Your implementation of "member" MUST be recursive and not use the builtin "contains" method from the List class.
  // EXAMPLES: 
  // - member (5, List (4, 6, 8, 5)) == true
  // - member (3, List (4, 6, 8, 5)) == false
  def member (a : Int, xs : List[Int]) : Boolean = {
    xs match {
      case Nil               => false
      case y::_ if (y == a)  => true
      case _::ys             => member(a, ys)   
    }
  }

  // EXERCISE 2: complete the following recursive definition of an "allEqual" function
  // to check whether all elements in a list of integers are equal.
  // EXAMPLES:
  // - allEqual (Nil) == true
  // - allEqual (List (5)) == true
  // - allEqual (List (5, 5, 5)) == true
  // - allEqual (List (6, 5, 5, 5)) == false
  // - allEqual (List (5, 5, 6, 5)) == false
  // - allEqual (List (5, 5, 5, 6)) == false
  def allEqual (xs : List[Int]) : Boolean = {
    xs match {
      case Nil => true
      case y::_ => allEqualHelper(xs, y)
    }
  }

  def allEqualHelper(xs:List[Int], x:Int) : Boolean = {
    xs match {
      case Nil              => true
      case y::_ if (y != x) => false
      case _::ys            => allEqualHelper(ys, x)
    }
  }

  // EXERCISE 3: complete the definition of the following function that computes the length of
  // each String in a list, and returns the original Strings paired with their length.
  // For example:
  // 
  //   stringLengths (List ("the", "rain")) == List (("the", 3), ("rain", 4))
  //
  // You must not use recursion directly in the function.  You can use the "map" method 
  // of the List class.
  def stringLengths (xs:List[String]) : List[(String, Int)] = {
    xs.map(x => (x,x.length))
  }

  // EXERCISE 4: complete the function definition for "delete1" that takes
  // an element "x" and a list "ys", then returns the list where any
  // occurrences of "x" in "ys" have been removed.  Your definition of
  // "delete1" MUST be recursive.
  // EXAMPLE:
  // - delete1 ("the", List ("the","the","was","a","product","of","the","1980s")) == List ("was","a","product","of","1980s")
  def delete1 [X] (x:X, ys:List[X]) : List[X] = {
    ys match {
      case Nil   => Nil
      case z::zs => if (z == x) delete1(x, zs) else z :: delete1(x, zs)
    }
  }

  // EXERCISE 5: complete the function definition for "delete2" below.  It must 
  // have the same behavior as "delete1".  It must be written using "for comprehensions" 
  // and not use recursion explicitly.
  def delete2 [X] (x:X, ys:List[X]) : List[X] = {
    for (y <- ys; if y != x ) yield y
  }

  // EXERCISE 6: complete the function definition for "delete3" below.  It must 
  // have the same behavior as "delete1".  It must be written using the
  // builtin "filter" method for Lists and not use recursion explicitly.
  def delete3 [X] (x:X, ys:List[X]) : List[X] = {
    ys.filter((y:X) => (y != x))
  }

  // EXERCISE 7: complete the function definition for "removeDupes1" below.
  // It takes a list as argument, then returns the same list with
  // consecutive duplicate elements compacted to a single element.  
  // Duplicate elements that are separated by at least one distinct
  // element should be left alone.
  // EXAMPLE:
  // - removeDupes1 (List (1,1,2,3,3,3,4,4,5,6,7,7,8,9,2,2,2,9)) == List (1,2,3,4,5,6,7,8,9,2,9)
  def removeDupes1 [X] (xs:List[X]) : List[X] = {
    xs match {
      case Nil => Nil 
      case x::Nil => List(x)
      case y::ys => if (y == ys.head) removeDupes1(ys) else y :: removeDupes1(ys)
    }
  }

  // EXERCISE 8: write a function "removeDupes2" that behaves like "removeDupes1",
  // but also includes a count of the number of consecutive duplicate
  // elements in the original list (thus producing a simple run-length
  // encoding).  The counts are paired with each element in the output
  // list.
  // EXAMPLE:
  // - removeDupes2 (List (1,1,2,3,3,3,4,4,5,6,7,7,8,9,2,2,2,9)) == List ((2,1),(1,2),(3,3),(2,4),(1,5),(1,6),(2,7),(1,8),(1,9),(3,2),(1,9))
  def removeDupes2 [X] (xs:List[X]) : List[(Int, X)] = {
    // println(s"xs = $xs")
    xs match {
      case Nil => Nil 
      case y::ys => {
        // println(s"$y::$ys => removeDupes2($ys)")
        removeDupes2(ys) match {
          // case (c,v) :: tail if (v == y) => println(s"c=$c,  v=$v, tail=$tail"); (c + 1, y) :: tail
          case (c,v) :: tail if (v == y)    =>                                      (c + 1, y) :: tail
          // case tail                      => println(s"c=0,   v=0,  tail=$tail"); (1    , y) :: tail
          case tail                         =>                                      (1    , y) :: tail
        }
      }
    }
  }
  /*
  Init: removeDupes2 (List (1,1,2,3,3,2,2,2))
     y ::ys => removeDupes2(ys)
  1) 1 :: _ => removeDupes2(1,2,3,3,2,2,2)
  2) 1 :: _ => removeDupes2(2,3,3,2,2,2)
  3) 2 :: _ => removeDupes2(3,3,2,2,2)
  4) 3 :: _ => removeDupes2(3,2,2,2)
  5) 3 :: _ => removeDupes2(2,2,2)
  5) 2 :: _ => removeDupes2(2,2)
  6) 2 :: _ => removeDupes2(2)
  7  2 :: _ removeDupes2(()) // BASE CASE RETURN Nil 
  */


  // EXERCISE 9: complete the following definition of a function that splits a list
  // into a pair of two lists.  The offset for the the split position is given
  // by the Int argument.
  // The behavior is determined by:
  //
  //   for all n, xs:
  //     splitAt (n, xs) == (take (n, xs), drop (n, xs))   
  //
  // Your definition of "splitAt" must be recursive and must not use "take" or "drop".
  //
  // Your definition of "splitAt" must only travere the list once.  So
  // you cannot define your own versions of "take"/"drop" and use them
  // (because that would entail one traversal of the list with "take"
  // and then a second traversal with "drop").
  def splitAt [X] (n:Int, xs:List[X]) : (List[X], List[X]) = {
    (n, xs) match {
      case (_, Nil)               => (Nil, Nil)     // If List in Nil nothing to split 
      case (n, _)   if (n < 0)    => (List(), xs)   // if n is negative 
      case (n, y::ys)             =>  {
                                        val (ls, rs) = splitAt(n-1, ys) 
                                        if (n > 0) (y::ls,rs) else (ls, y :: rs)
                                      }
    }
  }


  // EXERCISE 10: complete the following definition of an "allDistinct" function that checks
  // whether all values in list are distinct.  You should use your "member" function defined earlier.
  // Your implementation must be recursive.
  // EXAMPLE:
  // - allDistinct (Nil) == true
  // - allDistinct (List (1,2,3,4,5)) == true
  // - allDistinct (List (1,2,3,4,5,1)) == false
  // - allDistinct (List (1,2,3,2,4,5)) == false
  def allDistinct (xs : List[Int]) : Boolean = {
    xs match {
      case Nil => true 
      case y::ys => if (member(y,ys)) false else  allDistinct(ys)
    }
  }
}

/*
sbt:CSC447> testOnly fp3tests 
[info] Compiling 1 Scala source to /home/nstanley/Dropbox/github/574/csc447/hw/scala/target/scala-2.12/classes ...
[info] Done compiling.
[info] fp3tests:
[info] - EX01 - member
[info] - EX02 - allEqual
[info] - EX03 - stringLengths
[info] - EX04 - delete1
[info] - EX05 - delete2
[info] - EX06 - delete3
[info] - EX07 - removeDupes1
[info] - EX08 - removeDupes2
[info] - EX09 - splitAt
[info] - EX10 - allDistinct
[info] ScalaTest
[info] Run completed in 164 milliseconds.
[info] Total number of tests run: 10
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 10, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[info] Passed: Total 10, Failed 0, Errors 0, Passed 10
[success] Total time: 3 s, completed Apr 26, 2019 8:58:11 PM
*/