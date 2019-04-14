```
scala> val result = for (x <- List (1, 2, 3, 4)) println (x)
1
2
3
4
result: Unit = ()

scala> val result = for (x <- List (1, 2, 3, 4)) yield x
result: List[Int] = List(1, 2, 3, 4)

scala> result
res0: List[Int] = List(1, 2, 3, 4)


scala> val result = for (x <- List (1, 2, 3, 4)) yield 2 * x
result: List[Int] = List(2, 4, 6, 8)

scala> val result = for (x <- List (1, 2, 3, 4)) yield x + " potato"
result: List[String] = List(1 potato, 2 potato, 3 potato, 4 potato)

scala> val result = for (x <- List (1, 2, 3, 4)) yield List (2 * x)
result: List[List[Int]] = List(List(2), List(4), List(6), List(8))

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ())) { for (x <- xs) println (x) }
1
2
3
4
5
6
7
8
result: Unit = ()

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ())) yield { for (x <- xs) yield 2 * x }
result: List[List[Int]] = List(List(2, 4, 6, 8), List(10, 12, 14), List(16), List())

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ()); x <- xs) yield x
result: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ())) yield { for (x <- xs) yield 2 * x }
result: List[List[Int]] = List(List(2, 4, 6, 8), List(10, 12, 14), List(16), List())

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ()); x <- xs) yield x
result: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8)

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ()); x <- xs.reverse) yield x
result: List[Int] = List(4, 3, 2, 1, 7, 6, 5, 8)

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ()).reverse; x <- xs) yield x
result: List[Int] = List(8, 5, 6, 7, 1, 2, 3, 4)

scala> val result = for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ()).reverse; x <- xs.reverse) yield x
result: List[Int] = List(8, 7, 6, 5, 4, 3, 2, 1)

scala> val result = (for (xs <- List (List (1, 2, 3, 4), List (5, 6, 7), List (8), List ()); x <- xs) yield x).reverse
result: List[Int] = List(8, 7, 6, 5, 4, 3, 2, 1)

scala> val result = for (x <- List (1, 2, 3, 4); y <- (1 to x).toList) yield y
result: List[Int] = List(1, 1, 2, 1, 2, 3, 1, 2, 3, 4)
```

