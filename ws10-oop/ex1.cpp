#include <iostream>

class A { 
public: 
  void foo () { std::cout << "A" << std::endl; } 
};

class B : public A {
public: 
  void foo () { std::cout << "B" << std::endl; } 
};

int main () { 
  std::cout << "sizeof (A) = " << sizeof (A) << std::endl;
  std::cout << "sizeof (B) = " << sizeof (B) << std::endl;
  A* x = new B ();
  x->foo (); 
}

/*
nstanley@nstanley-ud-ws-01:~/Dropbox/github/574/csc447/ws10-oop$ ./a.out 
sizeof (A) = 1
sizeof (B) = 1
A
*/