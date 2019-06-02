
Verify that the List type is covariant in Scala by entering the following Scala program into the Scala REPL.

```
sbt:nstanley> console
[info] Starting scala interpreter...
Welcome to Scala 2.12.7 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_201).
Type in expressions for evaluation. Or try :help.

scala> :paste
// Entering paste mode (ctrl-D to finish)

class B {
  def f (x:Int) : Int             = 1 
}

class C extends B {
  override def f (x:Int) : Int    = 2
  def g (arr:Array[String]) : Int = 3
}


// Exiting paste mode, now interpreting.

defined class B
defined class C

scala> val xs1:List[B] = List (new B, new B)
xs1: List[B] = List(B@10157e40, B@415368f1)

scala> val xs2:List[C] = List (new C, new C)
xs2: List[C] = List(C@4222f1af, C@6b10c58c)

scala> val xs3:List[B] = List (new B, new C)
xs3: List[B] = List(B@4cd4237a, C@c28e01)

scala> val xs4:List[B] = xs2
xs4: List[B] = List(C@4222f1af, C@6b10c58c)

scala> xs4 (1).f (0)
res0: Int = 2

```
Verify that the Array type is invariant in Scala by entering the following Scala program into the Scala REPL.

```
scala> :paste
// Entering paste mode (ctrl-D to finish)

class B {
  def f (x:Int) : Int             = 1 
}

class C extends B {
  override def f (x:Int) : Int    = 2
  def g (arr:Array[String]) : Int = 3
}


// Exiting paste mode, now interpreting.

defined class B
defined class C

scala> val xs1:Array[B] = Array (new B, new B)
xs1: Array[B] = Array(B@3ad46218, B@71791955)

scala> val xs2:Array[C] = Array (new C, new C)
xs2: Array[C] = Array(C@7e365778, C@2877297f)

scala> val xs3:Array[B] = Array (new B, new C)
xs3: Array[B] = Array(B@6520e8d8, C@5b34a4c2)

scala> val xs4:Array[B] = xs2
<console>:13: error: type mismatch;
 found   : Array[C]
 required: Array[B]
Note: C <: B, but class Array is invariant in type T.
You may wish to investigate a wildcard type such as `_ <: B`. (SLS 3.2.10)
       val xs4:Array[B] = xs2
                          ^

scala> xs4 (0) = new B
<console>:13: error: not found: value xs4
       xs4 (0) = new B
       ^

scala> xs2 (0).g ()
<console>:13: error: not enough arguments for method g: (arr: Array[String])Int.
Unspecified value parameter arr.
       xs2 (0).g ()
                 ^

scala> xs2 (0).g (Array("nick"))
res2: Int = 3
```
