// 2.1 Maximum of a List
def maximum (xs:List[Int]) : Option[Int] = {
    xs match {
        case Nil => None
        case y::ys => match {
            case None => Some(y)
            case Some (z) => Some (y max z)
        }
    }
}

// 2.2 Find Element
def find [X] (xs:List[X], p:X=>Boolean) : Option[X] = {
  xs match {
      case Nil           => None
      case y::ys if p(y) => Some(y)
      case _::ys         => find(ys, p)   
  }
}

// 2.3 Handle an Option - Pattern Matching
def oneFind (xs:List[String], s:String) : Option[String] = {
  xs.find ((x:String) => (x.length > s.length) && x.contains (s))
}

/*
scala> oneFind (List ("the", "rain", "in", "spain"), "i")
res1: Option[String] = Some(rain)

scala> oneFind (List ("the", "rain", "in", "spain"), "in")
res2: Option[String] = Some(rain)

scala> oneFind (List ("the", "rain", "in", "spain"), "ain")
res3: Option[String] = Some(rain)

scala> oneFind (List ("the", "rain", "in", "spain"), "pain")
res16: Option[String] = Some(spain)

scala> oneFind (List ("the", "rain", "in", "spain"), "rain")
res4: Option[String] = None
*/

def twoFind (xs:List[String], s:String) : Option[String] = {
  oneFind(xs, s) match {
    case None   => None
    case Some   => oneFind(xs, t)
  }
}

// 2.4 Handle an Option - flatMap
def twoFind (xs:List[String], s:String) : Option[String] = {
  oneFind (xs, s).flatMap ((t:String) => oneFind (xs, t))
}

// 3.3 Scala - Looping in Scala with a Function
import scala.annotation.tailrec

@tailrec
def potatoPrint (n:Int) : Unit = {
  if (!(n > 4)) {
    println ("%d potato".format (n))
    potatoPrint (n + 1)
  }
}

```
scala> potatoPrint(1)
1 potato
2 potato
3 potato
4 potato
```

//3.5 Scala - Counting Values
@tailrec
def countingValues(xs:List[Int], low:Int, high:Int) = {
  def helper (ys:List[Int], result:Int) : Int = {
    ys match {
      case Nil                            => result
      case z::zs if (low <= z && <= high) => helper(zs, result +1)
      case _::zs                          => helpter(zs, result)
    }
  }
  helper(xs,0)
}

// 3.6 Scala - Which Functions Are Tail Recursive?

/* The Scala library includes many other functions on lists that are common.
 * Below we define our own versions of these functions for pedagogical purposes,
 * but normally the library versions would be used instead.
 */

// MyGuess: No 
// @tailrec: "it contains a recursive call not in tail position"
// Correct! 
@tailrec
def append [X] (xs:List[X], ys:List[X]) : List[X] = {
  xs match {
    case Nil   => ys
    case z::zs => z :: append (zs, ys)
  }
}
// MyGuess: No 
// @tailrec: "it contains a recursive call not in tail position"
// Correct! 
@tailrec
def flatten [X] (xss:List[List[X]]) : List[X] = {
  xss match {
    case Nil     => Nil
    case ys::yss => ys ::: flatten (yss)
  }
}

// MyGuess: No 
// @tailrec: "it contains a recursive call not in tail position"
// Correct!
/* The "take" function takes the first n elements of a list. */
@tailrec
def take [X] (n:Int, xs:List[X]) : List[X] = {
  if (n <= 0) {
    Nil
  } else {
    xs match {
      case Nil   => Nil
      case y::ys => y :: take (n - 1, ys)
    }
  }
}

/* The "drop" function drop the first n elements of a list. */
// MyGuess: yes
// Correct!!! 
@tailrec
def drop [X] (n:Int, xs:List[X]) : List[X] = {
  if (n <= 0) {
    xs
  } else {
    xs match {
      case Nil   => Nil
      case y::ys => drop (n - 1, ys)
    }
  }
}

val sampleList : List[Int] = (1 to 12).toList
val takeresult : List[Int] = take (3, sampleList)
val dropresult : List[Int] = drop (3, sampleList)

/* Reverse a list.  This version is straightforward, but inefficient.  Revisited later on. */

// MyGuess: No 
// @tailrec: "it contains a recursive call not in tail position"
// Correct!
@tailrec
def reverse [X] (xs:List[X]) : List[X] = {
  xs match {
    case Nil   => Nil
    case y::ys => reverse (ys) ::: List (y)
  }
}

/* zip takes two lists and creates a single list containing pairs from the two lists
 * that occur at the same position.  The definition shows more sophisticated pattern
 * matching: the use of wildcards; overlapping patterns; and decomposing pairs and
 * lists simultaneously.  Note that the "xs" and "ys" in the third case shadow the
 * "xs" and "ys" parameters to the function.
 */

// MyGuess: yes 
// @tailrec: "it contains a recursive call not in tail position"
// Wrong
 @tailrec
def zip [X,Y] (xs:List[X], ys:List[Y]) : List[(X,Y)] = (xs, ys) match {
  case (Nil, _)       => Nil
  case (_, Nil)       => Nil
  case (x::xs, y::ys) => (x, y) :: zip (xs, ys)
}

val ziplist = zip (List (1, 2, 3), List ("the", "rain", "in", "spain"))

/* unzip decomposes a list of pairs into a pair of lists.
 * The recursive case illustrates pattern-matching the result of the
 * recursive call in order to apply an operation to the elements.
 */
// MyGuess: No 
// @tailrec: "it contains a recursive call not in tail position"
// Corret
 @tailrec
def unzip [X,Y] (ps:List[(X,Y)]) : (List[X], List[Y]) = {
  ps match {
    case Nil        => (Nil, Nil)
    case (x, y)::qs => {
      val (xs, ys) = unzip (qs)
      (x :: xs, y :: ys)
    }
  }
}

val unziplist = unzip (ziplist)

// ???
// <pastie>:13: error: @tailrec annotated method contains no recursive calls
// def reverse2 [X] (xs:List[X]) : List[X] = {


// MyGuess: yes 
// Correct
// @tailrec
def reverse2 [X] (xs:List[X]) : List[X] = {
  @tailrec
  def aux (xs:List[X], result:List[X]) : List[X] = xs match {
    case Nil   => result
    case y::ys => aux (ys, y :: result)
  }
  aux (xs, Nil)
}

// 4.1 flatMap for Lists




