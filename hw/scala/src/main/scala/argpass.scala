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

object argpass {

  class RefInt (initial : Int) {
    private var n : Int = initial 
    def get () : Int = n 
    def set (m : Int) : Unit = { n = m }
 }

  // EXERCISE 1: complete the following higher-order function.
  // It has one parameter f: a function that takes an instance of RefInt (see above for the definition of the class RefInt) and returns Unit (i.e., nothing interesting).
  // Your code must create ONLY ONE instance of RefInt, then call f three times.
  // f will update the integer stored in the instances of RefInt it is given.
  // Your code must return a tuple of the three integers provided by f in the order that they came back from calls, i.e., the integer from the first call to f is the first integer in the 
  // returned tuple.
  def refint1 (f : RefInt => Unit) : (Int, Int, Int) = {
    val refInt = new RefInt(0)
    refInt.set(1); f(refInt); val v1 = refInt.get()
    refInt.set(2); f(refInt); val v2 = refInt.get()
    refInt.set(3); f(refInt); val v3 = refInt.get()
    (v1, v2, v3)
  }

  // EXERCISE 2: complete the following higher-order function.
  // It has one parameter f: a function that takes an instance of RefInt (see above for the definition of the class RefInt) and returns Unit (i.e., nothing interesting).
  // Your code must create EXACTLY THREE instances of RefInt, then call f three times.
  // f will update the integer stored in the instances of RefInt it is given.
  // However, f will not do this update immediately.  
  // It will only do it after the third call to f: at that point it updates all three instances of RefInt that it has received as arguments so far.
  // Your code must return a tuple of the three integers provided by f in the order that they came back from calls, i.e., the integer from the first call to f is the first integer in the returned tuple.
  def refint2 (f : RefInt => Unit) : (Int, Int, Int) = {
      val refInt1 = new RefInt(1); f(refInt1);
      val refInt2 = new RefInt(2); f(refInt2);
      val refInt3 = new RefInt(3); f(refInt3);
    (refInt1.get(), refInt2.get(), refInt3.get())
  }

  // EXERCISE 3: complete the following function.
  // It has one parameter r: (a reference to) an instance of RefInt (see above for the definition of the class RefInt) and returns (a reference to) an instance of RefInt.
  // Your code must increment (add 1 to) the RefInt it receives and return double the original value (stored in a separate RefInt instance) as the result.

  def refint3 (r : RefInt) : RefInt = {
    val v = r.get()     // save original value 
    r.set(v + 1)        // update value of RefInt 
    (new RefInt(2*v))   // double original value
  }

  // EXERCISE 4: complete the following function.
  // It has two parameters
  // - r: (a reference to) an instance of RefInt (see above for the definition of the class RefInt); AND
  // - f: a function that accepts (a reference to) an instance of RefInt.
  // Your code must call f with a *copy* of the RefInt r, i.e., it must make a new instance of RefInt with the same Int.
  // Your code should return true if f has NOT changed the Int stored in the copy of r.  Otherwise it should return false.
  def refint4 (r : RefInt, f : RefInt => Unit) : Boolean = {
       val v1 = r.get()
       val copyr = new RefInt(v1)
       f(copyr)
       val v2 = copyr.get()
       (v1 == v2)
  }

  // EXERCISE 5: complete the following function.
  // It has one parameter: a list of (references to) RefInt instances.
  // Your code must CHANGE the argument it receives in a way that is visible to the caller.
  // Note that this is the Scala List type, which is immutable!
  // You can assume that the list you receive is not empty.
  def refint5 (xs : List[RefInt]) : Unit = {
    for (x<-xs) { x.set(x.get()-1) }
  }
}

/*
sbt:CSC447> testOnly argpasstests
[info] Compiling 1 Scala source to /home/nstanley/Dropbox/github/574/csc447/hw/scala/target/scala-2.12/classes ...
[info] Done compiling.
[info] argpasstests:
[info] - EX01 - refint1
[info] - EX02 - refint2
[info] - EX03 - refint3
[info] - EX04 - refint4
[info] - EX05 - refint5
[info] ScalaTest
[info] Run completed in 123 milliseconds.
[info] Total number of tests run: 5
[info] Suites: completed 1, aborted 0
[info] Tests: succeeded 5, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
*/