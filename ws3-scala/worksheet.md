# 2.1 Scheme Type Checking

Write and test a simple Scheme program to demonstrate that Scheme type checking is dynamic, i.e., does not occur until runtime.
```
SISC (1.16.6)
#;> (define (f) (- 5 "hello"))
#;> f
#<procedure f>
#;> (f)
Error in -: expected type number, got '"hello"'.
console:1:13: <from call to ->
---------------------------
To enable more detailed stack tracing, set the dynamic parameter max-stack-trace-depth to a non-zero value, e.g. 16.
---------------------------
Some stack trace entries may have been suppressed. To see all entries set the dynamic parameter suppressed-stack-trace-source-kinds to '().
#;> 
```

# 4.5 Literals and Arithmetic

Write some Scala expressions for Boolean, integer, character, and String literals. Write some Scala expressions involving arithmetic. Try them in the Scala REPL.

```
nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/hw/scala$ sbt 
[info] Loading project definition from /home/nstanley/Dropbox/github/574/csc447/hw/scala/project
[info] Loading settings for project scala from build.sbt ...
[info] Set current project to CSC447 (in build file:/home/nstanley/Dropbox/github/574/csc447/hw/scala/)
[info] sbt server started at local:///home/nstanley/.sbt/1.0/server/0b353b2cb5b8b33f5c0c/sock
sbt:CSC447> console
[info] Starting scala interpreter...
Welcome to Scala 2.12.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_201).
Type in expressions for evaluation. Or try :help.

scala> 1 + 2
res0: Int = 3

scala> val x = true 
x: Boolean = true

scala> true
res1: Boolean = true

scala> 1 * 4 + 3
res2: Int = 7

scala> val x5 = 5 
x5: Int = 5

scala> val x10= 10
x10: Int = 10

scala> val r0 = x5 + x10
r0: Int = 15

scala> r1 = x5 * x10
<console>:13: error: not found: value r1
       r1 = x5 * x10
       ^
<console>:14: error: not found: value r1
       val $ires0 = r1
                    ^

scala> val r1 = x5 * x10
r1: Int = 50

scala> val s1 = "Nicholas" 
s1: String = Nicholas

scala> val s2 = "Stanley"
s2: String = Stanley

scala> val s3 = s1 + " " + s2
s3: String = Nicholas Stanley

scala> !true
res3: Boolean = false

scala> true || false
res4: Boolean = true

scala> false && true
res5: Boolean = false
```
# 4.7 Val And Var


1. In the REPL, define a variable x using val and try to assign to it. What happens and why?
2. In the REPL, define a variable x using var and try to assign to it. What happens and why?
3. In the REPL, define a variable x using val without an initializing expression. Why does the REPL reject that?
4. In the REPL, define a variable x using val. Then define another variable x using val with a different value. Why does the REPL accept that? Which value is returned when you enter x into the REPL now?

```
scala> val x = 1
x: Int = 1

scala> var x = 1
x: Int = 1

scala> val x 
     | 
     | nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/hw/scala$ sbt 
[info] Loading project definition from /home/nstanley/Dropbox/github/574/csc447/hw/scala/project
[info] Loading settings for project scala from build.sbt ...
[info] Set current project to CSC447 (in build file:/home/nstanley/Dropbox/github/574/csc447/hw/scala/)
[info] sbt server started at local:///home/nstanley/.sbt/1.0/server/0b353b2cb5b8b33f5c0c/sock
sbt:CSC447> console
[info] Starting scala interpreter...
Welcome to Scala 2.12.3 (Java HotSpot(TM) 64-Bit Server VM, Java 1.8.0_201).
Type in expressions for evaluation. Or try :help.

scala> val x = 1 
x: Int = 1

scala> val x = 5
x: Int = 5

scala> x
res0: Int = 5
```

# 4.8 Tuples
Write some Scala expressions for tuples. Try them in the Scala REPL.
```
scala> var pair = ("Nick", "Stanley") 
pair: (String, String) = (Nick,Stanley)

scala> val t1 = (1, 2, 2, 4)
t1: (Int, Int, Int, Int) = (1,2,2,4)

scala> val t2 = (3, 4, 5)
t2: (Int, Int, Int) = (3,4,5)

scala> val r1 = t1 + t2
<console>:13: error: type mismatch;
 found   : (Int, Int, Int)
 required: String
       val r1 = t1 + t2
                     ^

scala> val r1 = (t1, t2)
r1: ((Int, Int, Int, Int), (Int, Int, Int)) = ((1,2,2,4),(3,4,5))

scala> t3 = ("hello",574) 
<console>:11: error: not found: value t3
       t3 = ("hello",574)
       ^
<console>:12: error: not found: value t3
       val $ires0 = t3
                    ^

scala> t3 = ("hello", 574 ) 
<console>:11: error: not found: value t3
       t3 = ("hello", 574 )
       ^
<console>:12: error: not found: value t3
       val $ires1 = t3
                    ^

scala> val t3 = ("hello", 574 ) 
t3: (String, Int) = (hello,574)

scala> t1 == t2 
<console>:14: warning: comparing case class values of types (Int, Int, Int, Int) and (Int, Int, Int) using `==' will always yield false
       t1 == t2
          ^
res0: Boolean = false

scala> b1 = (1,2)
<console>:11: error: not found: value b1
       b1 = (1,2)
       ^
<console>:12: error: not found: value b1
       val $ires2 = b1
                    ^

scala> val b1 = (1,2)
b1: (Int, Int) = (1,2)

scala> val b2 = (1,2)
b2: (Int, Int) = (1,2)

scala> b1 == b2
res1: Boolean = true

scala> 
```
# 4.9 Lists

Write some Scala expressions to build lists (the builtin Scala List type). Use the :: (cons) operator for some, and the List (...) form for others. Try your expressions in the Scala REPL.
```

scala> val list1 = List ()
list1: List[Nothing] = List()

scala> val list1 = 5 :: list1
<console>:12: error: recursive value list1 needs type
       val list1 = 5 :: list1
                        ^

scala> val list1 = 1 :: Nil
list1: List[Int] = List(1)

scala> list1
res0: List[Int] = List(1)

scala> list2 = 2 :: list1
<console>:12: error: not found: value list2
       list2 = 2 :: list1
       ^
<console>:13: error: not found: value list2
       val $ires0 = list2
                    ^

scala> val list2 = 2 :: list1
list2: List[Int] = List(2, 1)

scala> val list2 = list2.reverse
<console>:12: error: recursive value list2 needs type
       val list2 = list2.reverse
                   ^

scala> val list3 = list2.reverse
list3: List[Int] = List(1, 2)

scala> val list4 = 5 :: 3 :: 1 :: Nil
list4: List[Int] = List(5, 3, 1)

scala> val list5 = list3 :: list4
list5: List[Any] = List(List(1, 2), 5, 3, 1)

scala> val list6 = list3 ::: list4
list6: List[Int] = List(1, 2, 5, 3, 1)

/* SUMMARY: FROM WS 
 * * TUPLES: the type specifies the length, and individual components
 *   may have different types.
 *
 * * LISTS: the length is unbounded (and may even be infinite!), and
 *   individual components must have the same type.
 *
 * Tuples, lists, strings, etc., are all immutable.  You cannot
 * change them at all.
 */
```
# 4.10 Equality Testing
Warning: Scala equality testing syntax conflicts with Java:

1. Use == in Scala where you would use the equals method in Java, e.g., to test if two String instances contain the same characters.

```
scala> "nick" == "nick" 
res1: Boolean = true

scala> "nicK" == "nick"
res2: Boolean = false

scala> val n1 = "n1"
n1: String = n1

scala> val n2 = "n2"
n2: String = n2

scala> n1 == n2
res3: Boolean = false

scala> val nn = "n1"
nn: String = n1

scala> nn == n1
res4: Boolean = true
```

2. Use eq in Scala where you would use the == operator in Java, i.e., to test reference equality (that two references are pointing to the same instance).

```

scala> nn eq n1
res5: Boolean = true

scala> "nick" eq "nick"
res6: Boolean = true

scala> "nick" eq "nicK"
res7: Boolean = false

scala> List (1,2,3) == List (1,2,3) 
res8: Boolean = true

scala> List (1,2,3) eq List (1,2,3) 
res9: Boolean = false
```


Run Scala expressions in the REPL to convince yourself that this is correct.

# 4.11 Factorial

```
scala> :paste
// Entering paste mode (ctrl-D to finish)

def f (x:Int) : Int = {
  println ("x = %d".format(x))
  if (x <= 1) {
      1
  } else { 
      x * f (x - 1)
  }
} 

// Exiting paste mode, now interpreting.

f: (x: Int)Int

scala> f(5)
x = 5
x = 4
x = 3
x = 2
x = 1
res0: Int = 120

```
# 4.12 Upto

```
def upto (start: Int, stop: Int) : List[Int] = { 
    if ( start > stop) { Nil } 
    else { start :: upto (start + 1, stop) }
}

scala> def upto (start: Int, stop: Int) : List[Int] = { if ( start > stop) {0} start :: upto (start + 1, stop) }
<console>:11: error: value start is not a member of Int
       def upto (start: Int, stop: Int) : List[Int] = { if ( start > stop) {0} start :: upto (start + 1, stop) }
                                                                               ^
<console>:11: error: type mismatch;
 found   : Unit
 required: List[Int]
       def upto (start: Int, stop: Int) : List[Int] = { if ( start > stop) {0} start :: upto (start + 1, stop) }
                                                        ^

scala> def upto (start: Int, stop: Int) : List[Int] = { if ( start > stop) 0 start :: upto (start + 1, stop) }
<console>:11: error: value start is not a member of Int
       def upto (start: Int, stop: Int) : List[Int] = { if ( start > stop) 0 start :: upto (start + 1, stop) }
                                                                             ^
<console>:11: error: type mismatch;
 found   : Unit
 required: List[Int]
       def upto (start: Int, stop: Int) : List[Int] = { if ( start > stop) 0 start :: upto (start + 1, stop) }
                                                        ^

scala> :paste
// Entering paste mode (ctrl-D to finish)

def upto (start: Int, stop: Int) : List[Int] = { 
    if ( start > stop) {
        0
    } else {
        start :: upto (start + 1, stop) }
}

// Exiting paste mode, now interpreting.

<pastie>:14: error: type mismatch;
 found   : Int(0)
 required: List[Int]
        0
        ^

scala> :paste
// Entering paste mode (ctrl-D to finish)

def upto (start: Int, stop: Int) : List[Int] = { 
    if ( start > stop) { Nil } 
    else { start :: upto (start + 1, stop) }
}

// Exiting paste mode, now interpreting.

upto: (start: Int, stop: Int)List[Int]

scala> upto (1, 5)
res6: List[Int] = List(1, 2, 3, 4, 5)

scala> upto (1, 12)
res7: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

scala> upto (10, 20)
res8: List[Int] = List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

scala> (10 to 20).toList
res9: List[Int] = List(10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)

```
# 4.13 Repeat

Write a Scala function that takes an element and repeats it a given number of times.
```
scala> repeat ("hello", 5)
res0: List[String] = List(hello, hello, hello, hello, hello)

scala> repeat (13, 5)
res1: List[Int] = List(13, 13, 13, 13, 13)
```

```
scala> def repeat  [X] (x:X, r:Int) : List[X] = { if (r == 0) {Nil}; else { x :: repeat (x, r - 1) }}
repeat: [X](x: X, r: Int)List[X]

scala> repeat(1,12)
res1: List[Int] = List(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)

scala> repeat("nick",12)
res2: List[String] = List(nick, nick, nick, nick, nick, nick, nick, nick, nick, nick, nick, nick)

scala> 
```


# 4.14 Recursive List Traversal

Define a Scala function printCounter that prints out each element of a list on its own line with a counter. The function must be written using recursion. You can create additional auxiliary functions if you like.
The output should resemble:
```
scala> printCounter (List ("the", "rain", "in", "spain"))
[001] the
[002] rain
[003] in
[004] spain
```

```
// Unit is the equivalent of the C/Java void type
// The dummy value of type Unit is ().



scala> :paste 
// Entering paste mode (ctrl-D to finish)

def printCounterHelper [X] (l:List[X], c: Int) : Unit = {
    if (l.isEmpty) { () }
    else {
        println ("[%03d] %s".format (c, l(0)))
        printCounterHelper (l.drop(1), c + 1)
    } 
}

def printCounter (l:List[String]) : Unit = { 
    printCounterHelper (l, 1)
}


// Exiting paste mode, now interpreting.

printCounterHelper: [X](l: List[X], c: Int)Unit
printCounter: (l: List[String])Unit

scala> printCounter (List ("the", "rain", "in", "spain"))
[001] the
[002] rain
[003] in
[004] spain


```

# 4.15 Analyzing Functions

Consider the following Scala code:
```
def f [X] (xs:List[X]) : List[X] = {
  xs match {
    case Nil => Nil
    case y::ys => y::(y::(f (ys)))
  }
}
```

Develop some intuition for its effect by working out on paper:

the result of running f on a list of length 0 (there are not many!): 
```
--> Nil
``` 
the result of running f on a list of length 1: 
```
f (5::Nil)
--> 5::(5::(f (Nil)))
--> 5::(5::(Nil))
```
the result of running f on a list of length 2
```
f (4::(5::Nil))
-> 4::4::(f(5))
            |
            --> 5::(5::(f(Nil))
                           |
                            --> Nil
```
the result of running f on a list of length 3
```
f (3::(4::(5::Nil)))
--> 3::(3::(f (4::(5::Nil))))
--> 3::(3::(4::(4::(5::(5::(Nil))))))
```


