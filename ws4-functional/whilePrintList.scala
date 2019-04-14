def printList [X] (list:List[X]) : Unit = {
    var item = list
    while ( item != Nil) {
        println(item.head)
        item = item.tail
    }
}

/*
scala> :paste
// Entering paste mode (ctrl-D to finish)

def printList [X] (list:List[X]) : Unit = {
    var item = list
    while ( item != Nil) {
        println(item.head)
        item = item.tail
    }
}

// Exiting paste mode, now interpreting.

printList: [X](list: List[X])Unit

scala> var l = list(1,2,3,4)
<console>:11: error: not found: value list
       var l = list(1,2,3,4)
               ^

scala> var l = List(1,2,3,4)
l: List[Int] = List(1, 2, 3, 4)

scala> print
print   printList   printf   println

scala> printlList(l)
<console>:13: error: not found: value printlList
       printlList(l)
       ^

scala> printList(l)
1
2
3
4

scala> var l = List("a","b","c")
l: List[String] = List(a, b, c)

scala> printList(s)
<console>:13: error: not found: value s
       printList(s)
                 ^

scala> printList(l)
a
b
c
*/