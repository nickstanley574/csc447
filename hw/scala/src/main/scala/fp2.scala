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

object fp2 {

  // EXERCISE 1: complete the following recursive definition of a "map" function
  // for Scala's builtin List type.  You must not use the builtin "map" method.
  // Your implementation of "map" MUST be recursive.
  def map [A,B] (xs:List[A], f:A=>B) : List[B] = {
    xs match {
      case Nil    => Nil
      case y::ys  => f(y) :: map(ys, f)
    }
  }

  // EXERCISE 2: complete the following recursive definition of a "filter" function
  // for Scala's builtin List type.  You must not use the builtin "filter" method.
  // Your implementation of "filter" MUST be recursive.
  def filter [A] (xs:List[A], f:A=>Boolean) : List[A] = {
    xs match {
      case Nil              => Nil
      case y::ys  if f (y)  => y :: filter (ys, f)
      case _::ys            => filter (ys, f)  
    }
  }

  // EXERCISE 3: complete the following recursive definition of an "append" function
  // for Scala's builtin List type.  You must not use the builtin ":::" method.
  // Your implementation of "append" MUST be recursive.
  // HINT: use "::" in the body of the cons-cell case.
  def append [A] (xs:List[A], ys:List[A]) : List[A] = {
    xs match { 
        case List() => ys
        case z :: zs => z :: append(zs, ys)
    }
  }

  // EXERCISE 4: complete fthe following recursive definition of a "flatten" function
  // for Scala's builtin List type.  You must not use the builtin "flatten" method.
  // Your implementation of "flatten" MUST be recursive.
  // HINT: use either ":::" or your definition of "append" in the body of the cons-cell case.
  // EXAMPLE:
  // - flatten (List ((1 to 5).toList, (6 to 10).toList, (11 to 15).toList)) == (1 to 15).toList
  def flatten [A] (xss:List[List[A]]) : List[A] = {
    xss match {
      case Nil     => Nil 
      case xs::xss => xs ::: flatten(xss)
    }
  }

  // EXERCISE 5: complete the following recursive definition of a "foldLeft" function
  // for Scala's builtin list type.  You must not use the builtin "foldLeft" method.
  // Your implementation of "foldLeft" MUST be recursive.
  // HINT:   foldLeft (  Nil, e, f) == e
  //         foldLeft (y::ys, e, f) == foldLeft (ys, f (e, y), f)
  // foldLeft ((1 to 3).toList, "@", f) === "@[1][2][3]"
  def foldLeft [A,B] (xs:List[A], e:B, f:(B,A)=>B) : B = {
    // println("--> foldLeft()")
    // println(xs)
    xs match {
      case Nil => e
      case y::ys => foldLeft (ys, f (e, y), f)
    }
  }

  // EXERCISE 6: complete the following recursive definition of a "foldRight" function
  // for Scala's builtin list type.  You must not use the builtin "foldRight" method.
  // Your implementation of "foldRight" MUST be recursive.
  // HINT:   foldRight (  Nil, e, f) == e
  //         foldRight (y::ys, e, f) == f (y, foldRight (ys, e, f))
  def foldRight [A,B] (xs:List[A], e:B, f:(A,B)=>B) : B = {
    xs match {
      case Nil => e
      case y::ys => f (y, foldRight (ys, e, f))
    }
  }

  // EXERCISE 7: complete the following definition of a "joinTerminateRight" function
  // to take a list of strings "xs" and concatenate all strings using a string "term"
  // as a terminator (not delimiter) between strings.  You MUST use your foldRight defined above.
  // EXAMPLES: 
  // - joinTerminateRight (Nil, ";") == ""
  // - joinTerminateRight (List ("a"), ";") == "a;"
  // - joinTerminateRight (List ("a","b","c","d"), ";") == "a;b;c;d;"
  def joinTerminateRight (xs : List[String], term : String) : String = {
    // def f (n : String, s : String) : String = n + term + s
    foldRight(xs, "", (n : String, s : String) => n + term + s)
  }
  /*
  joinTerminateRight (List ("a","b","c","d"), ";")

  -- init call 
  foldRight(List ("a","b","c","d"), "", (n : String, s : String) => n + ";" + s)
  xs = List ("a","b","c","d")  e="" f=(n : String, s : String) => n + ";" + s)

  1) "a" + ";" + foldRight (List("b","c","d"), "", f)           |     f ("a", foldRight (List("b","c","d"), "", f))
  2) "b" + ";" + foldRight (List("c","d")    , "", f)           |     f ("b", foldRight (List("c","d"),     "", f))
  3) "c" + ";" + foldRight (List("d")        , "", f)           |     f ("c", foldRight (List("d"),         "", f))
  4) "d" + ";" + foldRight (Nil              , "", f)           |     f ("d", foldRight (List(),            "", f))

  -- base case! 
  foldRight(Nil, "", f) = ""

  -- return back up r calls
  4) "d" + ";" + ""        = "d;"
  3) "c" + ";" + "d;"      = "c;d;"
  2) "b" + ";" + "c;d;"    = "b;c;d"
  1) "a" + ";" + "b;c;d;"  = "a;b;c;d" <-- last return 
  */

  // EXERCISE 8: complete the following definition of a "joinTerminateLeft" function
  // to take a list of strings "xs" and concatenate all strings using a string "term"
  // as a terminator (not delimiter) between strings.  You MUST use your foldLeft defined above.
  // EXAMPLES:
  // - joinTerminateLeft (Nil, ";") == ""
  // - joinTerminateLeft (List ("a"), ";") == "a;"
  // - joinTerminateLeft (List ("a","b","c","d"), ";") == "a;b;c;d;"
  def joinTerminateLeft (xs : List[String], term : String) : String = {
    foldLeft(xs,"",(n : String, s : String)  => n + s + term)
  }

  // EXERCISE 9: complete the following recursive definition of a "firstNumGreaterThan" function
  // to find the first number greater than or equal to "a" in a list of integers "xs".
  // If the list is empty or there is no number greater than or equal to "a",
  // throw a java.util.NoSuchElementException (with no argument).
  // Your implementation of "firstNumGreaterThan" MUST be recursive.
  // EXAMPLES:
  // - firstNumGreaterThan (5, List (4, 6, 8, 5)) == 6
  def firstNumGreaterThan (a : Int, xs : List[Int]) : Int = {
    xs match {
      case Nil                => throw new java.util.NoSuchElementException
      case y::ys if (y >= a)  => y 
      case _::ys              => firstNumGreaterThan(a, ys)
    }
  }

  // EXERCISE 10: complete the following recursive definition of a "firstIndexNumGreaterThan" function
  // to find the index (position) of the first number greater than or equal to "a" in a list of integers "xs".
  // If the list is empty or there is no number greater than or equal to "a", throw a
  // java.util.NoSuchElementException (with no argument).
  // The first index should be zero (not one).
  // Your implementation of "firstIndexNumGreaterThan" MUST be recursive.
  // EXAMPLES:
  // - firstIndexNumGreaterThan (5, List (4, 6, 8, 5)) == 1
  // HINT: this is a bit easier to write if you use an auxiliary function.
  def firstIndexNumGreaterThan (a : Int, xs : List[Int]) : Int = {
    firstIndexNumGreaterThanAux(a : Int, xs : List[Int], 0)
  }

  private def firstIndexNumGreaterThanAux (a : Int, xs : List[Int], i : Int ) : Int = {
    xs match {
      case Nil                => throw new java.util.NoSuchElementException
      case y::ys if (y >= a)  => i 
      case _::ys              => firstIndexNumGreaterThanAux(a, ys, i+1)
    }
  }

    // ------------- OR! -------------

  // def firstIndexNumGreaterThan (a : Int, xs : List[Int], index : Int = 0) : Int = {
  //     xs match {
  //       case Nil                => throw new java.util.NoSuchElementException
  //       case y::ys if (y >= a)  => index 
  //       case _::ys              => firstIndexNumGreaterThan(a, ys, index+1)
  //   }
  // }
}


// sbt:CSC447> testOnly fp2tests
// [info] fp2tests:
// [info] - EX01 - map
// [info] - EX02 - filter
// [info] - EX03 - append
// [info] - EX04 - flatten
// [info] - EX05 - foldLeft
// [info] - EX06 - foldRight
// [info] - EX07 - joinTerminateRight
// [info] - EX08 - joinTerminateLeft
// [info] - EX09 - firstNumGreaterThan
// [info] - EX10 - firstIndexNumGreaterThan
// [info] ScalaTest
// [info] Run completed in 154 milliseconds.
// [info] Total number of tests run: 10
// [info] Suites: completed 1, aborted 0
// [info] Tests: succeeded 10, failed 0, canceled 0, ignored 0, pending 0
// [info] All tests passed.
// [info] Passed: Total 10, Failed 0, Errors 0, Passed 10
// [success] Total time: 0 s, completed Apr 15, 2019, 1:14:21 PM



