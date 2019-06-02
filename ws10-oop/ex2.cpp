#include <iostream>

class A { 
public: 
  virtual void foo () { std::cout << "A" << std::endl; } 
};

class B : public A {
public: 
  void foo () override { std::cout << "B" << std::endl; } 
};

int main () { 
  std::cout << "sizeof (A) = " << sizeof (A) << std::endl;
  std::cout << "sizeof (B) = " << sizeof (B) << std::endl;
  A* x = new B ();
  x->foo (); 
}

/*
nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws10-oop$ ./a.out 
sizeof (A) = 8
sizeof (B) = 8
B
*/