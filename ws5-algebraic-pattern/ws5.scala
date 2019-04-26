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

def repeat [X] (x:X, n:Int) : List[X] = {
  if (n == 0)
    Nil
  else 
    x :: repeat (x, n - 1)
}

val xs:List[(Char,Int)] = List(('a',2), ('b',4), ('c',8))

val ys = xs.map((p:(Char,Int)) => repeat (p._1, p._2))
// ys: List[List[Char]] = List(List(a, a), List(b, b, b, b), List(c, c, c, c, c, c, c, c))


val zs = xs.flatMap ((p:(Char,Int)) => repeat(p._1, p._2))
// zs: List[Char] = List(a, a, b, b, b, b, c, c, c, c, c, c, c, c

val zs2 = xs.flatten((p:(Char,Int)) => repeat (p._1, p._2))
// zs2: List[Char] = List(a, a, b, b, b, b, c, c, c, c, c, c, c, c)

val zs3 = xs.map((p:(Char,Int)) => repeat (p._1, p._2)).flatten
// zs3: List[Char] = List(a, a, b, b, b, b, c, c, c, c, c, c, c, c)


// 5.1 Java Translation
// class Counter {
//   private static int numCounters = 0;

//   final int id;
//   int count;

//   Counter (int initial) {
//     this.id = numCounters;
//     this.count = initial;
//     numCounters++;
//   }

//   static int getNumCounters () {
//     return numCounters;
//   }

//   int getId () {
//     return this.id;
//   }

//   int getNextCount () {
//     return this.count++;
//   }
// }

object Counter {
  private var numCounters = 0 
  def getNumCounters () : Int = numCounters
  def incNumCounters () : Unit = numCounters  = numCounters + 1 
}

class Counter (initial:Int) {
  private val id:Int = Counter.getNumCounters
  private var count:Int = initial 
  Counter.incNumCounters

  def getId () : Int = id

  def getNextCount() : Int = {
    var tmp = count
    count = count + 1
    tmp
  }

}


// 6.1 MyList Case Class

trait MyList [+X]
case object MyNil                              extends MyList[Nothing]
case class MyCons[+X] (head:X, tail:MyList[X]) extends MyList[X]

def length [X] (xs:MyList[X]) : Int = {
  xs match {
    case MyNil => 0
    case MyCons (_,ys) => 1 + length(ys)
  }
}

def toList [X] (xs:MyList[X]) : List[X] = {
  xs match {
    case MyNil => Nil
    case MyCons (y, ys) => y::toList(ys) 
  }

def fromList [X] (xs:List[X]) : MyList[X] = {
  xs match {
    case Nil => MyNil
    case y::ys => MyCons(y, fromList(ys))
  }
}

def append [X] (xs:MyList[X], ys:MyList[X]) : MyList[X] = {
  xs match {
    case MyNil => ys
    case MyCons(z,zs) => MyCons(z, append(zs,ys))
  }
}

/*
scala> val lst = List(1,2,3,4)
lst: List[Int] = List(1, 2, 3, 4)

scala> val myLst = fromList(lst)
myLst: MyList[Int] = MyCons(1,MyCons(2,MyCons(3,MyCons(4,MyNil))))

scala> val lst2 = List(5,6)
lst2: List[Int] = List(5, 6)

scala> val myLst2 = fromList(lst2)
myLst2: MyList[Int] = MyCons(5,MyCons(6,MyNil))

scala> append(myLst, myLst2)
res5: MyList[Int] = MyCons(1,MyCons(2,MyCons(3,MyCons(4,MyCons(5,MyCons(6,MyNil))))))
*/

def map[X,Y] (xs:MyList[X], f:X=>Y) : MyList[Y] = {
  xs match {
    case MyNil => MyNil 
    case MyCons (y, ys) => MyCons MyCons(f(y), map(ys, f))
  }
}

//6.2 Binary Tree Case Class

trait Tree[+X]
case object Leaf                                 extends Tree[Nothing]
case class  Node[+X] (l:Tree[X], c:X, r:Tree[X]) extends Tree[X]

val tree1:Tree[Int] = Leaf

val tree2:Tree[Int] = Node (Leaf, 5, Leaf)

val tree3:Tree[Int] = Node (Node (Leaf, 2, Leaf), 3, Node (Leaf, 4, Leaf))

// Find the size of a binary tree.  Leaves have size zero here.
def size [X] (t:Tree[X]) : Int = {
  t match {
    case Leaf => 0;
    case Node (t1,_,t2) => size(t1) + 1 + size(t2)
  }
}

/*

defined trait Tree
defined object Leaf
defined class Node
tree1: Tree[Int] = Leaf
tree2: Tree[Int] = Node(Leaf,5,Leaf)
tree3: Tree[Int] = Node(Node(Leaf,2,Leaf),3,Node(Leaf,4,Leaf))
size: [X](t: Tree[X])Int

scala> size(tree1)
res6: Int = 0

scala> size(tree2)
res7: Int = 1

scala> size(tree3)
res8: Int = 3

*/

// Insert a number into a sorted binary tree.
def insert [X] (x:X, t:Tree[X], lt:(X,X)=>Boolean) : Tree[X] = {
  t match {
    case Leaf => (Leaf, x, Leaf)                                             // INSERT
    case Node(t1, v, t2) if (lt(x,v)) => Node (insert(x, t1, lt), c, t2)     // GO LEFT 
    case Node(t1, v, t2) if (lt(v,x)) => Node (t1, c, insert(x,t2,lt))       // GO RIGNT
    case Node(t1, v, t2) if (x == c)  => Node (t1, c, t2)                    // OVERRWRITE
  }
}

// Put the elements of the tree into a list using an in-order traversal.
def inorder [X] (t:Tree[X]) : List[X] = {
  t match {
    Leaf => Nil
    case Node (t1, c, t2) => inorder inorder(t1) ::: List(c) ::: inorder (t2)
  }
}


