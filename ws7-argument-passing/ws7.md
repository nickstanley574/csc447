# 3 L-Value or Not?

1. Is `x++` an l-value in C? The context is:
```
void f (int x) {
  x++
}
```
No temp value 

2. Is `arr[x++]` an l-value in C? The context is:
```
void f (int x) {
  int arr[] = { 5, 6, 7, 8, 9, 10, 11 };
  arr[x++]
}
```
yes

3. Is f `().x` an l-value in C? The context is:
```
struct S {
  int x;
  int y;
};

struct S f () {
  struct S s;
  s.x = 5;
  s.y = 6;
  return s;  // returns a copy of the "struct S", i.e., copies the two int members back
}

void g () {
  f().x
}
```

4. Is `t.x` an l-value in C? The context is:
```
struct S {
  int x;
  int y;
};

struct S f () {
  struct S s;
  s.x = 5;
  s.y = 6;
  return s;  // returns a copy of the "struct S", i.e., copies the two int members back
}

void g () {
  struct S t = f ();
  t.x
}
```
yes 

5. Is `f ()->x` an l-value in C? Recall that this means `(*(f())).x`, i.e., call `f`, dereference the pointer, then access the `x` member of the struct. The context is:
```
#include <stdlib.h>

struct S {
  int x;
  int y;
};

struct S *f () {
  struct S *p = (struct S *) malloc (sizeof (struct S));
  p->x = 5;   // recall that p->x is just shorthand for (*p).x
  p->y = 6;
  return p;  // returns a copy of the pointer, i.e., copies just a pointer back
}

void g () {
  f ()->x
}
```
Yes, pointer is temporary, but field is not

6. Is `arr[x++]` an l-value in Java? The context is:
```
class LValue6 {
  static void f (int x) {
    int[] arr = { 5, 6, 7, 8, 9, 10, 11 };
    arr[x++]
  }
}
```
Yes, array



7. Is list.get `(x++)` an l-value in Java? The context is:
```
import java.util.ArrayList;

class LValue7 {
  static void f (int x) {
    ArrayList<Integer> list = new ArrayList<> (); 
    list.add (5); 
    list.add (6); 
    list.add (7); 
    list.add (8); 
    (x++)
  }
}
```
No, temporary Integer


8. Is `list.get (x++).x` an l-value in Java? The context is:
```
import java.util.ArrayList;

class C {
  int x;
  int y;
  C (int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class LValue8 {
  static void f (int x) {
    ArrayList<C> list = new ArrayList<> (); 
    list.add (new C (5, 5)); 
    list.add (new C (6, 6)); 
    list.add (new C (7, 7)); 
    list.add (new C (8, 8)); 
    list.get (x++).x
  }
}
```
Yes, all object access via pointers/references in Java


--- 

# 6 Scope and Recursive Values
1. Write a Scala expression alternates of type Stream\[Boolean\] that alternates between true and false (starting with true).

```
val alternates:Stream[Boolean] = true #:: false #:: alternates

```
https://scastie.scala-lang.org/MVtPgEGkQG6
```
"the rain in spain".toList
val alternates:Stream[Boolean] = true #:: false #:: alternates
"the rain in spain".toList.zip (alternates)
"the rain in Spain".toList.zip (alternates).filter ((p:(Char,Boolean)) => p match { case (c:Char,b:Boolean) => b })
"the rain in Spain".toList.zip (alternates).filter { case (c:Char,b:Boolean) => b }     
val evens = "the rain in Spain".toList.zip (alternates).filter { case (c:Char,b:Boolean) => b }.map (p => p._1)
val odds = "the rain in Spain".toList.zip (alternates).filter { case (c:Char,b:Boolean) => !b }.map (p => p._1)
evens.zip (odds)
```