#include <stdio.h>
#include <stdlib.h>

#define ARR_SIZE 16

struct S {
  int x;
  int y;
  int arr[ARR_SIZE];
};

void print_S (struct S *p) {
  printf ("S {\n  x = %d,\n  y = %d,\n  arr = [ ", p->x, p->y);
  for (int i = 0; i < ARR_SIZE; i++) {
    printf ("%02X, ", p->arr[i]);
  }
  printf ("],\n}\n");
}

void f (struct S s) {
  printf ("s in f #1\n");
  print_S (&s);
  s.x = s.x + 1;                /* increment s.x      (first way to write it) */
  s.y += 1;                     /* increment s.y      (second way to write it) */
  for (int i = 0; i < ARR_SIZE; i++) {
    s.arr[i]++;                 /* increment s.arr[i] (third way to write it) */
  }
  printf ("s in f #2\n");
  print_S (&s);
}

int main (void) {
  struct S t;
  t.x = 5;
  t.y = 6;
  for (int i = 0; i < ARR_SIZE; i++) {
    t.arr[i] = i;
  }
  //printf ("sizeof(struct S)=%lu\n", sizeof(struct S));
  printf ("t in main #1\n");
  print_S (&t);
  f (t);
  printf ("t in main #2\n");
  print_S (&t);
}