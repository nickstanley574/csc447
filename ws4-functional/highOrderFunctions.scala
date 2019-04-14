// Write Scala functions that take a list of integers xs:List[Int] as a parameter and:

// print each integer in xs (use the method foreach from the List class)
def printList (xs:List[Int]) = xs.foreach((x:Int) => print(x + "->") )
// scala> printList(List(1,2,3,4,5))
// 1->2->3->4->5->


// create a new list with the squares of each integer from xs (use the method map from the List class)
def squares (xs:List[Int]) = xs.map((x:Int) => x*x)
// scala> squares(List(5,10))
// res0: List[Int] = List(25, 100)


// create a new list containing the odd numbers from xs (use the method filter from the List class)
def odds (xs:List[Int]) = xs.filter((x:Int) => x%2 == 1)
// scala> odds(List(1,2,3,4,5,6,7,8,9,10))
// res0: List[Int] = List(1, 3, 5, 7, 9)


// return an Option[Int] with the first integer greater than or equal to 5 if it exists in xs (use the method find from the List class; look in the Scala API documentation!)
def fiveOrGreater (xs:List[Int]) = xs.find((x:Int) => (x >= 5)) 
// scala> fiveOrGreater(List(1,4,2,8,2,5))
// res1: Option[Int] = Some(8)
// scala> fiveOrGreater(List(1,5,6))
// res2: Option[Int] = Some(5)


// count the number of integers greater than or equal to 5 in xs (use the method count from the List class; look in the Scala API documentation!)
def numFiveOrGreater (xs:List[Int]) = xs.count((x:Int) => x >= 5)
// scala> numFiveOrGreater(List(1,2,3,4,5,6,7,8,9,10))
// res3: Int = 6


// return a Boolean indicating whether there are any integers greater than or equal to 5 in xs (use the method exists from the List class; look in the Scala API documentation!)
def existsFiveOrGreater (xs: List[Int]) = xs.exists((x:Int) => (x>=5))
// scala> existsFiveOrGreater(List(1,4,5,2))
// res0: Boolean = true
// scala> existsFiveOrGreater(List(1,4,3,2))
// res1: Boolean = false


// return a Boolean indicating whether all integers in xs are greater than or equal to 5 (use the method forall from the List class; look in the Scala API documentation!)
def forallFiveOrGreater (xs:List[Int]) = xs.forall ((x:Int) => (x >= 5))
// scala> forallFiveOrGreater(List(5,6,7,8,9))
// res2: Boolean = true
// scala> forallFiveOrGreater(List(5,6,7,8,1))
// res3: Boolean = false