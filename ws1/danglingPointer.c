#include <stdio.h>
#include <stdlib.h>

int foo (int n) {
  int result = 2 * n;
  return result;
}

int main () {
  int x = foo (5);
  int y = foo (7);
  printf ("%d\n", x);
  printf ("%d\n", y);
}

#include <stdio.h>
#include <stdlib.h>

int* foo2 (int n) {
  int result = 2 * n;
  return &result;
}

int main2 () {
  int* p = foo2 (5);
  int* q = foo2 (7);
  printf ("%p %d\n", p, *p);
  printf ("%p %d\n", q, *q);  
}

/*
The second program is problematic because p is a dangling pointer after foo returns. That is, p contains a pointer 
to an area of memory that is not defined, and when it is dereferenced (using *p) the behavior is not guaranteed: 
it might be 10, some other value, or crash the program. This happens because the result variable is allocated in 
the activation record for foo, and the address of result is returned from foo, but the activation record for foo 
is deallocated (hence the memory storing result is also deallocated) when foo returns. (ASK PROF)
*/