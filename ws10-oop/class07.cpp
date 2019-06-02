#include <iostream>

class A { 
public: 
  int u;
  int v;
  virtual void f () { } 
  virtual void g () { } 
};

class B : public A {
public:  
  int w;
  int x;
  void g () override { } 
  virtual void h () { } 
};

int main () { 
  std::cout << "sizeof (A) = " << sizeof (A) << std::endl;
  std::cout << "sizeof (B) = " << sizeof (B) << std::endl;
  B* p1 = new B ();
  B* p2 = new B ();
  p1->u = 0x11111111;
  p1->v = 0x22222222;
  p1->w = 0x33333333;
  p1->x = 0x44444444;
  p2->u = 0x55555555;
  p2->v = 0x66666666;
  p2->w = 0x77777777;
  p2->x = 0x88888888;
  printf ("p1 = %p\n", (long *) (p1));
  printf ("p2 = %p\n", (long *) (p2));
  for (int i = 0; i < 5; i++) {
    printf ("p1[%d] = %p\n", i, ((long **) (p1))[i]);
    printf ("p2[%d] = %p\n", i, ((long **) (p2))[i]);
  }
  for (int i = 0; i < 3; i++) {
    printf ("p1[0][%d] = %p\n", i, ((long ***) (p1))[0][i]);
  }

  A* q1 = new A ();
  A* q2 = new A ();
  q1->u = 0x11111111;
  q1->v = 0x22222222;
  q2->u = 0x55555555;
  q2->v = 0x66666666;
  printf ("q1 = %p\n", (long *) (q1));
  printf ("q2 = %p\n", (long *) (q2));
  for (int i = 0; i < 5; i++) {
    printf ("q1[%d] = %p\n", i, ((long **) (q1))[i]);
    printf ("q2[%d] = %p\n", i, ((long **) (q2))[i]);
  }
  for (int i = 0; i < 3; i++) {
    printf ("q1[0][%d] = %p\n", i, ((long ***) (q1))[0][i]);
  }
}