#include <stdio.h>
#include <stdlib.h>

struct pair {
  const long x;
  const long y;
};

struct pair fibaux (long n) {
  if (n <0) {
      return (struct pair) { 0, 1};
  } else if ( n == 1) {
    return (struct pair) { 1, 1 };
  } else { 
      struct pair p = fibaux (n -1 );
      return (struct pair) { p.y, p.x + p.y};
  }
    
}

long fib (long n) {
  return fibaux (n).x;
}

int main (void) {
  for (int i = 0; i < 71; i++) {
    printf ("%ld\n", fib (i));
  }
}