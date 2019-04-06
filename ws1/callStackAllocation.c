#include <stdio.h>
#include <stdlib.h>

void countdown (int n) {
  if (n <= 0) {
    printf ("done\n");
  } else {
    printf ("counting down\n");
    countdown (n - 1);
  }
}

int main () {
  countdown (5);
}

/*
What will be printed?

counting down
counting down
counting down
counting down
counting down
done

What is the maximum number of activation records (also known as stack frames) on the call stack at one point during execution?

main
count with n = 5
count with n = 4
count with n = 3
count with n = 2
count with n = 1
count with n = 0

http://pythontutor.com/c.html#code=void%20countdown%20%28int%20n%29%20%7B%0A%20%20if%20%28n%20%3C%3D%200%29%20%7B%0A%20%20%20%20printf%20%28%22done%5Cn%22%29%3B%0A%20%20%7D%20else%20%7B%0A%20%20%20%20printf%20%28%22counting%20down%5Cn%22%29%3B%0A%20%20%20%20countdown%20%28n%20-%201%29%3B%0A%20%20%7D%0A%7D%0A%0Aint%20main%20%28%29%20%7B%0A%20%20countdown%20%285%29%3B%0A%7D&curInstr=24&mode=display&origin=opt-frontend.js&py=c&rawInputLstJSON=%5B%5D
*/